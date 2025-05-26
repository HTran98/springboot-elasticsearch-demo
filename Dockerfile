FROM ubuntu:latest
LABEL authors="hieutv"

ENTRYPOINT ["top", "-b"]
FROM docker.elastic.co/elasticsearch/elasticsearch:8.13.0

RUN elasticsearch-plugin install analysis-kuromoji

# Cho phép chạy mà không có security (demo dev)
ENV discovery.type=single-node
ENV xpack.security.enabled=false

# Default ports
EXPOSE 9200
