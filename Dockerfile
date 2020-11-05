FROM gcc:10
WORKDIR /app/
COPY suanfu.c ./
RUN gcc suanfu.c -o program
RUN chmod +x program
