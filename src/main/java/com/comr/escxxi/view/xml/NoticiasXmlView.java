package com.comr.escxxi.view.xml;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.xml.MarshallingView;

import com.comr.escxxi.model.NoticiaModel;
import com.comr.escxxi.model.ViewNames;
import com.comr.escxxi.service.NoticiaService;

//llamamos al componente igual que la view pero con terminacion .xml
@Component(ViewNames.HomeGeneral.NOTICIAS + ".xml")
public class NoticiasXmlView extends MarshallingView{

	@Autowired
	@Qualifier("noticiaService")
	NoticiaService noticiaService;
	
	@Autowired
	public NoticiasXmlView(Jaxb2Marshaller marshaller) {
		super(marshaller);		
	}

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		List<NoticiaModel> nList = noticiaService.findAllNoticias();
		
		NoticiasXmlRoot noticiasXmlRoot = new NoticiasXmlRoot(nList);
		
		model.put("noticias", noticiasXmlRoot);
		
		super.renderMergedOutputModel(model, request, response);
	}

}
