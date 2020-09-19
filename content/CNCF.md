# CNCF

## [What Happens when Service Mesh Maintainers Get a Taste of Their Own Mesh? - Risha Mars & Carol Scott](https://www.youtube.com/watch?v=mSZ8llZDsOA)

### Troubleshhoting latency

Use Dive
Dive is kind a debugger, it's a ui that integrates with flagger
  - An always-up-to-date service catalog, including where services are deployed, which versions are running, who deployed them.
  - An instantaneous record of every rollout across every cluster, no matter how it got there.
  - A global service topology of all services and their relationships.
  - Automatic SLO (service level objective) tracking for any service.
  - Report cards for showing off just how good (or bad!) a service did.
  - Deploy policies that take into account SLO status, the state of dependencies, and what else is changing across your clusters.
GRPC Troubleshooting
linkerd tap equivalent on istio?
wireshark for troubleshooting

### Links

- [Dive](https://buoyant.io/2019/11/18/announcing-dive/)

## [Progressive Delivery with Flagger - Stefan Prodan, Weaveworks](https://www.youtube.com/watch?v=Fqso_bl9WPg)

Canary Release
Flagger works for A/B Testing (HTTP headers and cookies traffic routing)
BLue/Gree (Traffic mirroing)
Blue/Gree (Traffic switch)
Traffic mirroing, send the same data to both

It duplicates resources to do the AB

## [Service Mesh Is Still Hard. The Things we all Did Wrong & Tales of Woe - Lin Sun & William Morgan](https://www.youtube.com/watch?v=m0X6FLFaEp4)

## [Iteratively Implementing Istio: Zero to Service Mesh with No Downtime - Patrick Auld, Autodesk](https://www.youtube.com/watch?v=22q1KinMAXw)

## [Top 5 Challenges in Service Mesh Adoption at Enterprise - Ex... Vladimir Alekseev & Igor Gustomyasov](https://www.youtube.com/watch?v=ki8x8cFCLPI)

## [Service Mesh Failure Stories at Scale - Krzysztof Słonka, Allegro.pl](https://www.youtube.com/watch?v=lQxpIGBW4CQ)

## [Finding Managed Services in a Serverless World with Crossplane and OpenFaaS - Daniel Mangum, Upbound](https://www.youtube.com/watch?v=lQxpIGBW4CQ)

## [Chaos Engineering in a Serverless World - Divya Mohan, HSBC](https://www.youtube.com/watch?v=lQxpIGBW4CQ)

## [Application Autoscaling Made Easy With Kubernetes Event-Driven Autoscaling (KEDA) - Tom Kerkhove](https://www.youtube.com/watch?v=tJmz4xyoxT4)

## [Service Mesh Architectures Explained - Sidecar and Beyond - Manuel Zapf, Containous](https://www.youtube.com/watch?v=j7JKkbAiWuI)

Moving out of sidecar, one per node aproach

## [Meet faasd. Look Ma’ No Kubernetes! - Alex Ellis, OpenFaaS Ltd](https://www.youtube.com/watch?v=ZnZJXI377ak)

## [Multi Cluster and Multi Mesh Patterns - Christian Posta, Solo.io](https://www.youtube.com/watch?v=68rGx0WhiA0)

## [The State of Serverless - Jeremy Garcia, Datadog](https://www.youtube.com/watch?v=x-MkBlg-TPg)

## [Using Service Mesh in Multi-Cluster Kubernetes Environment for DR Use Case - Jun Wei, Equinix](https://www.youtube.com/watch?v=BsV5iHYIws8)

## [Istio Simplified - Louis Ryan, Google & Steve Dake, IBM](https://www.youtube.com/watch?v=vzLkJ4kGg_s)

## [Uncharted Territories: Discovering Vulnerabilities in Public Helm Charts - Hayley Denbraver, Snyk](https://www.youtube.com/watch?v=SNjL96WxPqo)

## [Tracing is For Everyone: Tracing User Events with GraphQL and OpenTelemetry - Nina Stawski, Splunk](https://www.youtube.com/watch?v=8Ldp9w8wm-U)

## [Mesh in a Mesh: A Model for Stronger Multi-tenancy of Kubernetes Wo... Nitish Malhotra & Akash Baid](https://www.youtube.com/watch?v=7XMgtfey5YI)