/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.trino.gateway;

import io.trino.gateway.ha.HaGatewayLauncher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.containers.TrinoContainer;

import java.util.List;

import static org.testcontainers.utility.MountableFile.forClasspathResource;

public final class TrinoGatewayRunner
{
    private TrinoGatewayRunner() {}

    public static void main(String[] args)
            throws Exception
    {
        TrinoContainer trino1 = new TrinoContainer("trinodb/trino:395");
        trino1.setPortBindings(List.of("8081:8080"));
        trino1.start();
        TrinoContainer trino2 = new TrinoContainer("trinodb/trino:395");
        trino2.setPortBindings(List.of("8082:8080"));
        trino2.start();

        PostgreSQLContainer<?> postgres = new PostgreSQLContainer("postgres:16");
        postgres.withUsername("trino_gateway_db_admin");
        postgres.withPassword("P0stG&es");
        postgres.withDatabaseName("trino_gateway_db");
        postgres.withCopyFileToContainer(forClasspathResource("gateway-ha-persistence-postgres.sql"), "/docker-entrypoint-initdb.d/1-gateway-ha-persistence-postgres.sql");
        postgres.withCopyFileToContainer(forClasspathResource("add_backends_postgres.sql"), "/docker-entrypoint-initdb.d/2-add_backends_postgres.sql");
        postgres.setPortBindings(List.of("5432:5432"));
        postgres.start();

        MySQLContainer<?> mysql = new MySQLContainer("mysql:5.7");
        mysql.withUsername("root");
        mysql.withPassword("root123");
        mysql.withDatabaseName("trinogateway");
        mysql.withCopyFileToContainer(forClasspathResource("gateway-ha-persistence.sql"), "/docker-entrypoint-initdb.d/1-gateway-ha-persistence.sql");
        mysql.withCopyFileToContainer(forClasspathResource("add_backends.sql"), "/docker-entrypoint-initdb.d/2-add_backends.sql");
        mysql.setPortBindings(List.of("3306:3306"));
        mysql.start();

        HaGatewayLauncher.main(new String[]{"server", "gateway-ha/gateway-ha-config.yml"});

        Logger log = LoggerFactory.getLogger(TrinoGatewayRunner.class);
        log.info("======== SERVER STARTED ========");
    }
}
