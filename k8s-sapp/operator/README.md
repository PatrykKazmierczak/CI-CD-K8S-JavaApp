git clone https://github.com/CrunchyData/postgres-operator-examples/

kubectl apply -k kustomize/install/namespace

kubectl apply --server-side -k kustomize/install/default