package com.comr.escxxi.view.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import com.comr.escxxi.entity.Noticia;
import com.comr.escxxi.model.NoticiaModel;

@XmlRootElement(name="noticias")
public class NoticiasXmlRoot {
	
	@XmlElement(name="noticia")
	public List<NoticiaModel> noticiasList;
	
	public NoticiasXmlRoot() {}

	public NoticiasXmlRoot(List<NoticiaModel> nList) {
		this.noticiasList = nList;
	}

	public List<NoticiaModel> getNoticiasList() {
		return noticiasList;
	}
		
}
