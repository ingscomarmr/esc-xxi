package com.comr.escxxi.view.xlsx;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.comr.escxxi.entity.Noticia;
import com.comr.escxxi.model.ViewNames;
import com.comr.escxxi.service.NoticiaService;

@Component(ViewNames.HomeGeneral.NOTICIAS + ".xlsx")
public class NoticiasXlsxView extends AbstractXlsxView{

	@Autowired
	@Qualifier("noticiaService")
	NoticiaService noticiaService;
	
	
	private enum Columns{A,B,C,D,E,F;}
	
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.setHeader("Content-Disposition", "attachment; filename=\"noticias.xlsx\"");
		// TODO Auto-generated method stub
		List<Noticia> nList = noticiaService.findByTituloLikeOrContenidoLikeOrderByFechaVigenciaInicio("%");
		
		Sheet sheet = workbook.createSheet("Noticias");
		
		Row row = sheet.createRow(0);
		Cell cell = row.createCell(Columns.A.ordinal());
		cell.setCellValue("NOTICIAS ESC-XXI");
		
		row = sheet.createRow(1);
		cell = row.createCell(Columns.A.ordinal());
		cell.setCellValue("ID");
		cell = row.createCell(Columns.B.ordinal());
		cell.setCellValue("Titulo");
		cell = row.createCell(Columns.C.ordinal());
		cell.setCellValue("Contenido");
		cell = row.createCell(Columns.D.ordinal());
		cell.setCellValue("Fecha");
		
		int nRow = 1; 
		for (Noticia n : nList) {
			nRow += 1;		
			row = sheet.createRow(nRow);
			cell = row.createCell(Columns.A.ordinal());
			cell.setCellValue(n.getNoticiaId());
			cell = row.createCell(Columns.B.ordinal());
			cell.setCellValue(n.getTitulo());
			cell = row.createCell(Columns.C.ordinal());
			cell.setCellValue(n.getContenido());
			cell = row.createCell(Columns.D.ordinal());
			cell.setCellValue(n.getFechaVigenciaInicio().toString());
		}
		
		
		
	}

}
