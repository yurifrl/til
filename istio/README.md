# Istio Learning Material

## Begin

Prerequisites: docker-compose ~3.7, kubectl ~1.18, istioctl ~1.5.2

### Running kubernetes with docker

```shell
# This is the most important part
alias k=kubectl
# Start your cluster
docker-compose up -d
# Set this variable so kubectl will know about your cluster
export KUBECONFIG=$PWD/kubeconfig.yaml
# Change the context
k config set-context default
# Check if running
k get nodes
k cluster-info
```

### Install Istio

```shell
# One command
istioctl manifest apply --set profile=default --set values.global.proxy.autoInject=enable
# You can find more here https://istio.io/docs/setup/install/istioctl/
# And check the options here https://istio.io/docs/reference/config/installation-options
# To check an config in expecific
istioctl profile dump --config-path components.pilot demo
```

## Reading list
- [Introducing istiod: simplifying the control plane](https://istio.io/blog/2020/istiod/)
- [The obstacles to put Istio into production and how we solve them
](https://medium.com/@zhaohuabing/the-obstacles-to-put-istio-into-production-and-how-we-solve-them-90030b4dbbe5)
- [Troubleshooting Networking Issues](https://archive.istio.io/v1.1/help/ops/traffic-management/troubleshooting/)
- [Common Problems](https://istio.io/docs/ops/common-problems/)
- [Incremental Istio Part 1, Traffic Management](https://istio.io/blog/2018/incremental-traffic-management/)
- [Troubleshooting Istio](https://github.com/istio/istio/wiki/Troubleshooting-Istio)
- [Debugging Envoy and Istiod](https://istio.io/docs/ops/diagnostic-tools/proxy-cmd/)
- [Diagnostic Tools
](https://istio.io/docs/ops/diagnostic-tools/)
- [Course](https://app.linuxacademy.com/search?query=istio)
- [An istio tutorial](https://github.com/redhat-developer-demos/istio-tutorial)
- [Another istio tutorial](https://github.com/rafabene/istio-tutorial)

## Istio Instalation content
- [Customizable Install with Istioctl](https://istio.io/docs/setup/install/istioctl/)
- [Istio install options](https://istio.io/docs/reference/config/installation-options)

## Katacoda scenarios
- [kameshchauhan](https://github.com/kameshchauhan/katacoda-scenarios)
- [katacoda-scenarios](https://github.com/katacoda-scenarios/istio-katacoda-scenarios)
- [redhat-msa-3](https://github.com/redhat-msa-3/istio-workshop)
- [alperhankendi](https://github.com/alperhankendi/katacoda-scenarios)

## Run localy
- [k3s](https://github.com/rancher/k3s)
- [minikube](https://kubernetes.io/docs/setup/learning-environment/minikube/)
- [kind](https://kind.sigs.k8s.io/)

## Some References not istio related
- [k3s setup](https://medium.com/okteto/lightweight-kubernetes-development-with-k3s-and-okteto-4be08de516a)
- [k3s docs](https://rancher.com/docs/k3s/latest/en/installation/installation-requirements/)
- [k3s quickstart](https://github.com/mrchrd/k3s-quickstart)
- [okteto](https://okteto.com/)