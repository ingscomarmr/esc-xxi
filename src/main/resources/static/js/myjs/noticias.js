//#  Proyecto: ESC XXI
//#  Creador:Omar Munguia Rivera 
//#  Descripcion: Usado para ayuda de la view noticias
 

//iniciando la tabla bootgrid
$(window).load(function() {
	// alert('corriendo la tabla grid');
	try {
		$("#grid-data").bootgrid({
			ajax : true,
			post : function() {
				/* To accumulate custom parameter with the request object */
				return {
					id : "b0df282a-0d67-40e5-8558-c9e93b7befed"
				};
			},
			url : "/api/noticia/get-grid-noticias",
			formatters : {
				"titulo" : function(column, row) {
					var action = "\\noticia\\" + row.noticiaId;
					return '<a href="'+action+'">'+row.titulo+'</a>';
				},
				"link" : function(column, row) {
					var action = "\\noticia\\" + row.noticiaId;
					return '<a href="'+action+'">'+row.titulo+'</a>';
				}
				
			}
		});
	} catch (ex) {
		alert('Error activando menus:' + ex);
	}
});