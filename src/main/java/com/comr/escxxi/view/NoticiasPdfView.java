package com.comr.escxxi.view;

import static org.assertj.core.api.Assertions.catchThrowable;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.comr.escxxi.entity.Noticia;
import com.comr.escxxi.model.ViewNames;
import com.comr.escxxi.service.NoticiaService;
import com.lowagie.text.Document;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Component(ViewNames.HomeGeneral.NOTICIAS)
public class NoticiasPdfView extends AbstractPdfView{

	@Autowired
	@Qualifier("noticiaService")
	NoticiaService noticiaService;
	
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		PdfPTable tabla = new PdfPTable(1);	
		PdfPCell cTitulo = new PdfPCell(new Phrase("NOTICIAS ESC-XXI"));
		cTitulo.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);			
		tabla.addCell(cTitulo);
		
		
		PdfPTable nTable = new PdfPTable(4);
		nTable.addCell("ID");
		nTable.addCell("Titulo");
		nTable.addCell("Contenido");
		nTable.addCell("Fecha");
		
		List<Noticia> nList = noticiaService.findByTituloLikeOrContenidoLikeOrderByFechaVigenciaInicio("%");
		for (Noticia n : nList) {
			nTable.addCell(n.getNoticiaId().toString());
			nTable.addCell(n.getTitulo());
			nTable.addCell(n.getContenido());
			nTable.addCell(n.getFechaVigenciaInicio().toString());
		}
		
		
		document.add(tabla);
		document.add(nTable);
		
	}

}
