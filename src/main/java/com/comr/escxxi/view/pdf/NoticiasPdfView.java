package com.comr.escxxi.view.pdf;


import java.awt.Color;
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
import com.lowagie.text.Font;
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
		
		Color colorPrimary = new Color(125, 66, 169);
		Color colorFontPrimary = new Color(255,255,255);
		Color colorSecond = new Color(255,134,92);
		
		
		PdfPTable tabla = new PdfPTable(1);	
		PdfPCell cTitulo = new PdfPCell(new Phrase("NOTICIAS ESC-XXI",new Font(Font.BOLD, 12, Font.ITALIC, colorFontPrimary)));
		cTitulo.setBackgroundColor(colorPrimary);
		cTitulo.setPadding(10f);
		cTitulo.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);			
		tabla.addCell(cTitulo);
		
		
		PdfPTable nTable = new PdfPTable(4);
		nTable.setWidths(new int[] {8,30,45,17});
		
		//ID
		PdfPCell ctId = new PdfPCell(new Phrase("ID",new Font(Font.BOLD, 12, Font.ITALIC, colorFontPrimary)));
		ctId.setBackgroundColor(colorSecond);
		ctId.setPadding(10f);
		ctId.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		
		//Titulo
		PdfPCell ctTitulo = new PdfPCell(new Phrase("Titulo",new Font(Font.BOLD, 12, Font.ITALIC, colorFontPrimary)));
		ctTitulo.setBackgroundColor(colorSecond);
		ctTitulo.setPadding(10f);
		ctTitulo.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		
		//Contenido
		PdfPCell ctContenido = new PdfPCell(new Phrase("Contenido",new Font(Font.BOLD, 12, Font.ITALIC, colorFontPrimary)));
		ctContenido.setBackgroundColor(colorSecond);
		ctContenido.setPadding(10f);
		ctContenido.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		
		
		//Fecha
		PdfPCell ctFecha = new PdfPCell(new Phrase("Fecha",new Font(Font.BOLD, 12, Font.ITALIC, colorFontPrimary)));
		ctFecha.setBackgroundColor(colorSecond);
		ctFecha.setPadding(10f);
		ctFecha.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		
		nTable.addCell(ctId);
		nTable.addCell(ctTitulo);
		nTable.addCell(ctContenido);
		nTable.addCell(ctFecha);
		
		List<Noticia> nList = noticiaService.findByTituloLikeOrContenidoLikeOrderByFechaVigenciaInicio("%");
		for (Noticia n : nList) {
			PdfPCell ctIdItem = new PdfPCell(new Phrase(n.getNoticiaId().toString()));
			ctIdItem.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
			nTable.addCell(ctIdItem);
			nTable.addCell(n.getTitulo());
			nTable.addCell(n.getContenido());
			nTable.addCell(n.getFechaVigenciaInicio().toString());
		}
		
		
		document.add(tabla);
		document.add(nTable);
		
	}

}
