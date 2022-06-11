# Protkoll
## Tutorial Durchlesen und Dokumentieren

Zunächst ist es wichtig ein Registration Service zu erstellen. Dabei wird die Annotation `@EnableEurekaServer` verwendet. In der `registration-server.yml` wird dann mittels `registerWithEureka: false
fetchRegistry: false` konfiguriert, dass es nicht als MicroService erkannt wird. (Da es ja keines ist sonder die MicroServices registriert und es soll sich ja nicht selber registrieren)
In jeder Config wird der Port des jeweiligen Services angegeben. In der Main Methode wird immer als System Property der Name des Services gesetzt.
In der Konfig von MicroServices wird das register Service angegeben. `eureka:
client:
serviceUrl:
defaultZone: http://localhost:1111/eureka/`

Mittels `@LoadBalanced` kann man anfordern, dass ein Service LoadBalanced wird.

Mittels `eureka.instance.leaseRenewalIntervalInSeconds` kann man die Refresh Rate änder, mit welcher neue Services registriert werden. Default ist 30 Sekunden.

## Durchführung

Zuerst habe ich mir die Dokumentation zum Account Service durchgelesen und dokumentiert. Danach habe ich angefangen den MarathonServer zu schreiben und den RestController mal grundsätzlich implementiert. Ebenfalls habe ich die marathon-server.yml geschrieben.

## Fragestellungen
+ Was versteht man unter Microservices?
  > Microservices allow large systems to be built up from a number of collaborating components. It does at the process level what Spring has always done at the component level: loosely coupled processes instead of loosely coupled components. [1]

+ Stellen Sie anhand eines Beispiels den Einsatz von Microservices dar.
  > For example imagine an online shop with separate microservices for user-accounts, product-catalog order-processing and shopping carts: Inevitably there are a number of moving parts that you have to setup and configure to build such a system. [1]

+ Wie kann man Spring Cloud nutzen und welche Tools werden dabei unterstützt?
  > Die Cloud kann schnell in Spring integriert werden. Folgendes [Tutorial](https://spring.io/guides/gs/centralized-configuration/) beschreibt wie.
  > - Service discovery
  > - API gateway
  > - Cloud configuration
  > - Circuit breakers
  > - Tracing
  > - Testing
  [3]
  
+ Beschreiben Sie das Spring Cloud Netflix Projekt. Aus welchen Bestandteilen setzt sich dieses Projekt zusammen?
  > The patterns provided include Service Discovery (Eureka), Circuit Breaker (Hystrix), Intelligent Routing (Zuul) and Client Side Load Balancing (Ribbon). [2]

+ Wofür werden die Annotations @EnableEurekaServer und @EnableDiscoveryClient verwendet?
  > You first need a Eureka Service registry. You can use Spring Cloud’s @EnableEurekaServer to stand up a registry with which other applications can communicate. This is a regular Spring Boot application with one annotation (@EnableEurekaServer) added to enable the service registry. [8]
  > Now that you have started a service registry, you can stand up a client that both registers itself with the registry and uses the Spring Cloud DiscoveryClient abstraction to interrogate the registry for its own host and port. The @EnableDiscoveryClient activates the Netflix Eureka DiscoveryClient implementation. [8]
+ Wie werden in dem Account Service die Properties gesetzt und welche Parameter werden hier verwendet?
  > Einerseits werden die Properties in der `account-server.yml` gesetzt. Dabei werden folgende Properties gesetzt:
  > 1. Sets the application name as accounts-service. This service registers under this name and can also be accessed by this name - see below.
  > 2. Specifies a custom port to listen on (2222). All my processes are using Tomcat, they can’t all listen on port 8080.
  > 3. The URL of the Eureka Service process - from the previous section.
  > ```yml 
  > # Spring properties
  > spring:
  >   application:
  >     name: accounts-service
  >
  > # Discovery Server Access
  > eureka:
  >   client:
  >     serviceUrl:
  >       defaultZone: http://localhost:1111/eureka/
  >
  > # HTTP Server
  > server:
  >   port: 2222   # HTTP (Tomcat) port
  > ```
+ Wie funktioniert das Logging bei diesem Beispiel? Ist es möglich das Logging zu erhöhen bzw. komplett abzudrehen?
  Wenn ja, wie?
  > In diesem Beispiel funktioniert das Logging mittels der in SpringBoot implementieren logback Library.
  > Um das Logging zu erhöhen oder zu deaktivieren muss man das Logging Level in der `logback.xml` von aktuell WARN auf z.B INFO, ALL oder OFF ändern. 

## Zusatzfragen

1. Definition des Begriffs "Service Mesh"
   > Ein Service Mesh ist eine Plattformebene über der Infrastrukturebene, die eine verwaltete, beobachtbare und sichere Kommunikation zwischen einzelnen Diensten ermöglicht. Auf dieser Plattformebene können Unternehmen oder Einzelpersonen robuste Unternehmensanwendungen erstellen, die sich aus vielen Mikrodiensten in einer ausgewählten Infrastruktur zusammensetzen. Service Meshes verwenden einheitliche Tools, um alle gängigen Anforderungen für das Ausführen eines Dienstes wie Monitoring, Netzwerk und Sicherheit zu berücksichtigen. Dies bedeutet, dass sich Dienstentwickler und -betreiber auf die Erstellung und Verwaltung von Anwendungen für ihre Nutzer konzentrieren können, anstatt sich um die Implementierung von Maßnahmen kümmern zu müssen, um Herausforderungen für jeden Dienst zu bewältigen. [4]
2. Was sind die Funktionalitaeten eines "Service Mesh"?
   > Service Meshes bieten bestimmte Funktionen zur Verwaltung und Steuerung von Kommunikationsbeziehungen zwischen Diensten. Einige dieser Funktionen werden in den folgenden Unterabschnitten erläutert.
   > - Mehrinstanzenfähigkeit
   >   - Namespace-Mandantenfähigkeit
   >   - Cluster-Mehrinstanzenfähigkeit
   > - Sicherheit
   > - Beobachtbarkeit und Analyse
   >   - Messwerte
   >     - Proxy-Messwerte: Sidecar-Proxys generieren eine Vielzahl von Messwerten zu allen eingehenden und ausgehenden Proxy-Traffics. Diese Messwerte enthalten detaillierte Statistiken über die administrativen Funktionen des Proxys, wie Konfigurationsinformationen und Systeminformationen. 
   >     - Service Level-Messwerte: Dienstmesswerte beziehen sich auf die vier goldenen Überwachungssignale: Latenz, Traffic, Fehler und Sättigung. 
   >     - Messwerte der Steuerungsebene: Messwerte der Steuerungsebene überwachen die Service Mesh-Steuerungsebene und nicht die Dienste im Mesh-Netzwerk.
   >   - Verteilte Traces
   >   - Zugriffslogs
   > - Compliance
   >   - Monitoring und Auditing
   >   - Sicherheit
   >   - Redundanz
   >   - Hochverfügbarkeit
   >   - Notfallwiederherstellung
   >   - Partitionierung
   >   - Laufzeitattribute
   > - Verkehrsüberwachung
   >   - Load-Balancing
   >   - Quellenbeschränkung (Anrufer)
   > - Robustheit
   >   - Zuverlässigkeit von Mikrodienstaufrufen erhöhen 
   >   - Aufruffehler absichtlich erstellen
   > 
   > [4]

3. Recherchieren nach 2 bekannten Herstellern eines "Service Mesh" und beschreiben kurz deren Funktionsumfang
    > 1. Istio
    >    Istio extends Kubernetes to establish a programmable, application-aware network using the powerful Envoy service proxy. Working with both Kubernetes and traditional workloads, Istio brings standard, universal traffic management, telemetry, and security to complex deployments. [5]
    > 2. LINKERD
    >    Ultra light, ultra simple, ultra powerful. Linkerd adds security, observability, and reliability to Kubernetes, without the complexity. CNCF-hosted and 100% open source.
    > 
    >    - Instant platform health metrics
    >      Instantly track success rates, latencies, and request volumes for every meshed workload, without changes or config.
    >    - Simpler than any other mesh
    >      Minimalist, Kubernetes-native design. No hidden magic, as little YAML and as few CRDs as possible.
    >    - Zero-config mutual TLS
    >      Transparently add mutual TLS to any on-cluster TCP communication with no configuration.
    >    - Designed by engineers, for engineers
    >      Self-contained control plane, incrementally deployable data plane, and lots and lots of diagnostics and debugging tools.
    >    - Drop-in reliability features
    >      Instantly add latency-aware load balancing, request retries, timeouts, and blue-green deploys to keep your applications resilient.
    >    - State-of-the-art ultralight Rust dataplane
    >      Incredibly small and blazing fast Linkerd2-proxy micro-proxy written in Rust for security and performance.
    >   [6]
       
4. Stellen Sie die 2 Produkte gegenueber und vergleichen Sie diese
   > Istio: Open platform to connect, manage, and secure microservices, by Google, IBM, and Lyft. Istio is an open platform for providing a uniform way to integrate microservices, manage traffic flow across microservices, enforce policies and aggregate telemetry data. Istio's control plane provides an abstraction layer over the underlying cluster management platform, such as Kubernetes, Mesos, etc; linkerd: Twitter-Style Operability for Microservices. linkerd is an out-of-process network stack for microservices. It functions as a transparent RPC proxy, handling everything needed to make inter-service RPC safe and sane--including load-balancing, service discovery, instrumentation, and routing. [7]

## Quellen
[1] "Microservices with Spring"; Spring; [Online](https://spring.io/blog/2015/07/14/microservices-with-spring); zuletzt besucht am 24.05.2022
[2] "Part III. Spring Cloud Netflix"; Spring; [Online](https://cloud.spring.io/spring-cloud-static/Greenwich.SR1/multi/multi__spring_cloud_netflix.html); zuletzt besucht am 24.05.2022
[3] "Cloud"; Spring; [Online](https://spring.io/cloud); zuletzt besucht am 24.05.2022
[4] "Service Meshes in einer Mikrodienst-Architektur"; Google; [Online](https://cloud.google.com/architecture/service-meshes-in-microservices-architecture); zuletzt besucht am 24.05.2022
[5] "The Istio service mesh"; Istio; [Online](https://istio.io/); zuletzt besucht am 24.05.2022
[6] "A different kind of service mesh"; LINKERD; [Online](https://linkerd.io/); zuletzt besucht am 24.05.2022
[7] "Istio vs linkerd"; StackShare"; [Online](https://stackshare.io/stackups/istio-vs-linkerd); zuletzt besucht am 24.05.2022
[8] "Service Registration and Discovery"; Spring; [Online](https://spring.io/guides/gs/service-registration-and-discovery/); zuletzt besucht am 11.06.2022