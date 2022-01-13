package com.idat.android.app.service;

import java.io.IOException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.idat.android.app.dao.DocumentoAlmacenadoDao;
import com.idat.android.app.model.DocumentoAlmacenado;
import com.idat.android.app.service.utils.GenericResponse;
import com.idat.android.app.service.utils.Globals;


@Service
@Transactional
public class DocumentoAlmacenadoService {
    private DocumentoAlmacenadoDao dao;
    private FileStorageService storageService;

    public DocumentoAlmacenadoService(DocumentoAlmacenadoDao dao, FileStorageService storageService) {
        this.dao = dao;
        this.storageService = storageService;
    }

    public GenericResponse<Iterable<DocumentoAlmacenado>> list() {
        return new GenericResponse<Iterable<DocumentoAlmacenado>>(Globals.TIPO_RESULT, Globals.RPTA_OK, Globals.OPERACION_CORRECTA, dao.list());
    }


    @SuppressWarnings("rawtypes")
	public GenericResponse find(Long aLong) {
        return null;
    }


    @SuppressWarnings({ "rawtypes", "unchecked" })
	public GenericResponse save(DocumentoAlmacenado obj) {
        String fileName = (dao.findById(obj.getId())).orElse(new DocumentoAlmacenado()).getFileName();

        String originalFilename = obj.getFile().getOriginalFilename();
        String extension = originalFilename.substring(originalFilename.lastIndexOf("."));

        fileName = storageService.storeFile(obj.getFile(), fileName);

        obj.setFileName(fileName);
        obj.setExtension(extension);

        return new GenericResponse(Globals.TIPO_DATA, Globals.RPTA_OK, Globals.OPERACION_CORRECTA,dao.save(obj));
    }

    public ResponseEntity<Resource> download(String completefileName, HttpServletRequest request) {
        Resource resource = storageService.loadResource(completefileName);
        String contentType = null;

        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    public ResponseEntity<Resource> downloadByFileName(String fileName, HttpServletRequest request) {
        DocumentoAlmacenado doc = dao.findByFileName(fileName).orElse(new DocumentoAlmacenado());
        return download(doc.getCompleteFileName(), request);
    }


    @SuppressWarnings("rawtypes")
	public GenericResponse delete(Long aLong) {
        return null;
    }

    public HashMap<String, Object> validate(DocumentoAlmacenado obj) {
        return null;
    }
}
