    package com.example.Noticias_RestAPI.service;

    import com.example.Noticias_RestAPI.repository.NoticiasRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.ResponseEntity;
    import org.springframework.stereotype.Service;
    import org.springframework.web.client.RestTemplate;
    import com.example.Noticias_RestAPI.model.NoticiasEntity;

    @Service
    public class NoticiasService {
        @Autowired
        private NoticiasRepository noticiasRepository;

        private String consultarURL(String apiUrl){
            String dados = "";
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);
            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                dados = responseEntity.getBody();
            } else {
                dados = "Falha ao obter dados. Código de status: " + responseEntity.getStatusCode();
            }
            return dados;
        }

        public String consultarNoticias() {
            return consultarURL("https://servicodados.ibge.gov.br/api/v3/noticias/?tipo=noticia");
        }
        public String consultarRelease() {
            return consultarURL("https://servicodados.ibge.gov.br/api/v3/noticias/?tipo=release");
        }
        public String consultarNoticiaseRelease() {
            return consultarURL("https://servicodados.ibge.gov.br/api/v3/noticias");
        }

        public NoticiasEntity inserirNoticia(NoticiasEntity noticia) {
            return noticiasRepository.save(noticia);
        }

        public NoticiasEntity inserirRelease(NoticiasEntity release) {
            return noticiasRepository.save(release);
        }

    }

