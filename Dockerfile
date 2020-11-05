FROM gcc:10
WORKDIR /app/
COPY ./* ./
RUN gcc suanfu.c -o program
RUN chmod +x program
