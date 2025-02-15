**Trino Gateway documentation**

<table>
  <tr>
    <td>
      <img src="./assets/logos/trino-gateway-v.png"/>
    </td>
    <td>
      <ul>
        <li><a href="quickstart.md">Quickstart</a></li>
        <li><a href="installation.md">Installation</a></li>
        <li><a href="security.md">Security</a></li>
        <li><a href="operation.md">Operation</a></li>
      </ul>
    </td>
    <td>
      <ul>
        <li><a href="gateway-api.md">Gateway API</a></li>
        <li><a href="resource-groups-api.md">Resource groups API</a></li>
        <li><a href="routing-rules.md">Routing rules</a></li>
      </ul>
    </td>
    <td>
      <ul>
        <li><a href="design.md">Design</a></li>
        <li><a href="development.md">Development</a></li>
        <li><a href="release-notes.md">Release notes</a></li>
        <li><a href="references.md">References</a></li>
      </ul>
    </td>
  </tr>
</table>

# Release notes

## Trino Gateway 6 (16 Feb 2024)

[gateway-ha-6-jar-with-dependencies.jar](https://repo1.maven.org/maven2/io/trino/gateway/gateway-ha/6/gateway-ha-6-jar-with-dependencies.jar)

* Add Docker container build, publishing, and usage setup and instructions. ([#86](https://github.com/trinodb/trino-gateway/issues/86))

[Details about all pull requests and issues](https://github.com/trinodb/trino-gateway/issues?q=milestone%3A6+is%3Aclosed)


## Trino Gateway 5 (24 Jan 2024)

[gateway-ha-5-jar-with-dependencies.jar](https://repo1.maven.org/maven2/io/trino/gateway/gateway-ha/5/gateway-ha-5-jar-with-dependencies.jar)

* Add support for OAuth 2 audience use. (https://github.com/trinodb/trino-gateway/pull/164)
* Add quickstart scripts and documentation. (https://github.com/trinodb/trino-gateway/pull/110)
* Add project logo. (https://github.com/trinodb/trino-gateway/pull/111)
* Prevent ignoring HTTP header configuration. (https://github.com/trinodb/trino-gateway/issues/100)

[Details about all merged pull requests](https://github.com/trinodb/trino-gateway/pull/168)

## Trino Gateway 4 (30 Nov 2023)

[gateway-ha-4-jar-with-dependencies.jar](https://repo1.maven.org/maven2/io/trino/gateway/gateway-ha/4/gateway-ha-4-jar-with-dependencies.jar)

* Add support for configuring additional whitelisted URL paths. (https://github.com/trinodb/trino-gateway/pull/63)
* Improve flexibility of user and group name matching for authorization. (https://github.com/trinodb/trino-gateway/pull/32)
* Add support to use external URL for backend creation. (https://github.com/trinodb/trino-gateway/pull/76)
* Enable configuration of HTTP header size. (https://github.com/trinodb/trino-gateway/pull/67)
* Automatically set JDBC configuration parameter for TLS when connecting to
  clusters for monitoring. (https://github.com/trinodb/trino-gateway/pull/71)
* Modernize application and remove potential for undiscovered bugs and security
  issues with update of many core dependencies. (https://github.com/trinodb/trino-gateway/pull/59)
* Avoid failure when unhandled OIDC properties are present. (https://github.com/trinodb/trino-gateway/pull/69)
* Prevent failures resulting from reloading and parsing rules file. (https://github.com/trinodb/trino-gateway/pull/5)

[Details about all merged pull requests](https://github.com/trinodb/trino-gateway/pull/73)

## Trino Gateway 3 (26 Sep 2023)

[gateway-ha-3-jar-with-dependencies.jar](https://repo1.maven.org/maven2/io/trino/gateway/gateway-ha/3/gateway-ha-3-jar-with-dependencies.jar)

The first release of Trino Gateway is based on the [Presto
Gateway](https://github.com/lyft/presto-gateway/) 1.9.5 codebase
[#4](#4), with these additions:

* Add authentication and authorization with LDAP, OIDC and user list from config
  file. (https://github.com/trinodb/trino-gateway/pull/9)
* Add support for user, admin and API roles. (https://github.com/trinodb/trino-gateway/pull/9)
* Add healthcheck for Trino backends using JDBC. (https://github.com/trinodb/trino-gateway/pull/9)
* Add TCP check for routing. (https://github.com/trinodb/trino-gateway/pull/9)
* Add logic to route requests only to healthy backends. (https://github.com/trinodb/trino-gateway/pull/13)
* Add PostgreSQL support for backend database. (https://github.com/trinodb/trino-gateway/pull/13)
* Allow routing of `/v1/node` endpoint URL. (https://github.com/trinodb/trino-gateway/pull/27)
* Filter logs for sensitive information. (https://github.com/trinodb/trino-gateway/pull/9)
* Require Java 17 for build and runtime. (https://github.com/trinodb/trino-gateway/pull/16)
* Deactivate clusters with zero workers. (https://github.com/trinodb/trino-gateway/pull/13)
* Remove concurrency issue from repeated rules file loading. (https://github.com/trinodb/trino-gateway/pull/9)

[Details about all merged pull requests](https://github.com/trinodb/trino-gateway/pull/52)
