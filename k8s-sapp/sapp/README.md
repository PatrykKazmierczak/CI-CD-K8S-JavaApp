kubectl create secret tls sapp-ingress --cert=cert.pem --key=key.pem -o yaml --dry-run=client > secret-tls.yaml
