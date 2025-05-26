FROM docker.elastic.co/elasticsearch/elasticsearch:8.13.0

# Cài plugin Kuromoji không cần xác nhận (--batch)
RUN elasticsearch-plugin install --batch analysis-kuromoji
RUN elasticsearch-plugin install --batch analysis-icu
# Cấu hình đơn giản để chạy local
ENV discovery.type=single-node
ENV xpack.security.enabled=false

EXPOSE 9200
EXPOSE 9300
