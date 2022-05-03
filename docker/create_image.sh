#!/bin/bash
cd ../frontend
npm install
npm run build --prod --base-href="/new/"
cp -r dist/AdviceMe/* ../backend/src/main/resources/public/new
cd ../docker
docker build -f Dockerfile -t $1 ../backend
docker push $1