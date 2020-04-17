FROM pandit_base:0.1

COPY ./codebase  /home/codebase

COPY ./app_sourcefiles /home/app_sourcefiles

RUN cd /home/codebase/web && tar -xvf /home/app_sourcefiles/web_node_modules.tar.gz

RUN cd /home/codebase/batch && tar -xvf /home/app_sourcefiles/batch_node_modules.tar.gz

RUN cd /home/app_sourcefiles/shells && sed -i 's/\r//g' *

RUN mv /home/app_sourcefiles/shells/* /home/codebase/

RUN rm -fr /home/app_sourcefiles
