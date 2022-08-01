package br.JornalOAperitivo.RSS;

public class Noticias {
        // private String id;
        private String titulo;
        // private String corpo;
        private String data;
        private String linkNoticia;
        private String linkimagem;

        public Noticias(/* String id, */ String titulo, String data, /* String corpo, */ String linkNoticia,
                        String linkimagem) {
                // this.id = id;
                this.titulo = titulo;
                this.data = data;
                // this.corpo = corpo;
                this.linkNoticia = linkNoticia;
                this.linkimagem = linkimagem;
        }

        public Noticias(String entry) {
                // this.id = entry.split("<id>")[1]
                // .split("</id>")[0];
                this.titulo = entry.split("<title type='text'>")[1]
                                .split("</title>")[0];
                // this.corpo = entry.split("<content type='html'>")[1]
                // .split("</content>")[0];
                this.data = entry.split("<published>")[1]
                                .split("</published")[0];
                this.linkNoticia = entry.split("<link rel='alternate' type='text/html' href='")[1]
                                .split("' title='")[0];
                this.linkimagem = entry.split("a href=&quot;")[1]
                                .split("&quot;")[0];

        }

        public String json() {
                return "{'titulo':'" + this.titulo +
                // "',corpo:'" + this.corpo +
                                "','data':'" + this.data +
                                "','linkNoticia':'" + this.linkNoticia +
                                "','linkimagem':'" + this.linkimagem + "'},";

        }

        public String getTitulo() {
                return titulo;
        }

        public String getData() {
                return data;
        }

        public String getLinkNoticia() {
                return linkNoticia;
        }

        public String getLinkimagem() {
                return linkimagem;
        }

}
