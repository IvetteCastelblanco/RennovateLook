function enviar(event) {
	
	(event)?event.preventDefault():'';
	
	  const swalWithBootstrapButtons = Swal.mixin({
	    customClass: {
	      confirmButton: 'btn btn-success',
	      cancelButton: 'btn btn-danger'
	    },
	    buttonsStyling: false
	  })

  swalWithBootstrapButtons.fire({
    title: '¿Quieres Enviar El Formulario?',
    text: "Estas seguro de enviarlo",
    icon: 'warning',
    showCancelButton: true,
    confirmButtonText: 'Si',
    cancelButtonText: 'No',
    reverseButtons: true
  }).then((result) => {
    if (result.value) {
      swalWithBootstrapButtons.fire(
        'Enviado',
        'Su Correo Fue Enviado',
        'success'
      )
      document.getElementById(event.target.attributes.id.value).submit();
    } else if (
      /* Read more about handling dismissals below */
      result.dismiss === Swal.DismissReason.cancel
    ) {
      swalWithBootstrapButtons.fire(
        'Cancelado',
        'Su Formulario no fue enviado',
        'error'
      )
    }
  })
}

function validarforinventario(event) {
	var estado, nombre, marca, cantidad, valorpro, valortota, nombrepro, mensaje, expresion;
	estado = document.getElementById("estado").value;
	nombre = document.getElementById("nombre").value;
	marca = document.getElementById("marca").value;
	cantidad = document.getElementById("cantidad").value;
	valorpro = document.getElementById("valorpro").value;
	valortota = document.getElementById("valortota").value;
	nombrepro = document.getElementById("nombrepro").value;
	mensaje = document.getElementById("mensaje").value;

	if(estado === "" || nombre === "" || marca === "" || cantidad === "" || valorpro === "" || valortota === "" || nombrepro === "" || mensaje === ""){
		Swal.fire(
		'Te falta un campo?',
  		'!Todos los campos son obligatorios!',
  		'question'
		)
		return false;
	}
	else if(nombre.length>30) {
		Swal.fire({
		  position: 'top-end',
		  icon: 'warning',
		  title: 'El nombre es muy largo',
		  showConfirmButton: false,
		  timer: 1500
		})
		return false;
	}
	else if(marca.length>30) {
		Swal.fire({
		  position: 'top-end',
		  icon: 'warning',
		  title: 'El nombre de la marca es muy largo',
		  showConfirmButton: false,
		  timer: 1500
		})
		return false;
	}
	else if(cantidad.length>10) {
		Swal.fire({
		  position: 'top-end',
		  icon: 'warning',
		  title: 'El numero de la cantidad es muy largo',
		  showConfirmButton: false,
		  timer: 1500
		})
		return false;
	}
	else if(valorpro.length>10) {
		Swal.fire({
		  position: 'top-end',
		  icon: 'warning',
		  title: 'El valor producto es muy largo',
		  showConfirmButton: false,
		  timer: 1500
		})
		return false;
	}
	else if(valortota.length>10) {
		Swal.fire({
		  position: 'top-end',
		  icon: 'warning',
		  title: 'El valor total es muy largo',
		  showConfirmButton: false,
		  timer: 1500
		})
		return false;
	}
	else if(nombrepro.length>30) {
		Swal.fire({
		  position: 'top-end',
		  icon: 'warning',
		  title: 'El nombre del proveedor es muy largo',
		  showConfirmButton: false,
		  timer: 1500
		})
		return false;
	}
	else if(mensaje.length>250) {
		Swal.fire({
		  position: 'top-end',
		  icon: 'warning',
		  title: 'El mensaje es muy largo',
		  showConfirmButton: false,
		  timer: 1500
		})
		return false;
	}
	else if(isNaN(cantidad)) {
		Swal.fire({
		  position: 'top-end',
		  icon: 'error',
		  title: 'La cantidad ingresada no es numero',
		  showConfirmButton: false,
		  timer: 1500
		})
		return false;
	}else{
		enviar(event);
	}
}

function validarforventas(event) {
	
	var codigoproducto, cantidadproducto, cantidadservicio, valortota, efectivo, tarjeta;
	codigoproducto = document.getElementById("codigoproducto").value;
	cantidadproducto = document.getElementById("cantidadproducto").value;
	cantidadservicio = document.getElementById("cantidadservicio").value;
	valortota = document.getElementById("valortota").value;
	efectivo = document.getElementById("efectivo").value;
	tarjeta = document.getElementById("tarjeta").value;
	
	if(codigoproducto === "" || cantidadproducto === "" || cantidadservicio === "" || valortota === "" || efectivo === "" || valortota === "" || tarjeta === ""){
		Swal.fire(
		'Te falta un campo?',
  		'!Todos los campos son obligatorios!',
  		'question'
		)
		return false;
	}
	else if(codigoproducto.length>30) {
		Swal.fire({
		  position: 'top-end',
		  icon: 'warning',
		  title: 'El codigo del producto es muy largo',
		  showConfirmButton: false,
		  timer: 1500
		})
		return false;
	}
	else if(cantidadproducto.length>30) {
		Swal.fire({
		  position: 'top-end',
		  icon: 'warning',
		  title: 'El numero de la cantidad del producto es muy largo',
		  showConfirmButton: false,
		  timer: 1500
		})
		return false;
	}
	else if(cantidadservicio.length>10) {
		Swal.fire({
		  position: 'top-end',
		  icon: 'warning',
		  title: 'El numero de la cantidad servicio es muy largo',
		  showConfirmButton: false,
		  timer: 1500
		})
		return false;
	}
	else if(valortota.length>10) {
		Swal.fire({
		  position: 'top-end',
		  icon: 'warning',
		  title: 'El valor total es muy largo',
		  showConfirmButton: false,
		  timer: 1500
		})
		return false;
	}
	else if(efectivo.length>10) {
		Swal.fire({
		  position: 'top-end',
		  icon: 'warning',
		  title: 'No has seleccionado el campo',
		  showConfirmButton: false,
		  timer: 1500
		})
		return false;
	}
	else if(tarjeta.length>10) {
		Swal.fire({
		  position: 'top-end',
		  icon: 'warning',
		  title: 'No has seleccionado el campo',
		  showConfirmButton: false,
		  timer: 1500
		})
		return false;
	}
	else if(isNaN(codigoproducto)) {
		Swal.fire({
		  position: 'top-end',
		  icon: 'warning',
		  title: 'El codigo producto ingresado no es numero',
		  showConfirmButton: false,
		  timer: 1500
		})
		return false;
	}
	else if(isNaN(cantidadproducto)) {
		Swal.fire({
		  position: 'top-end',
		  icon: 'warning',
		  title: 'La cantidad producto ingresada no es numero',
		  showConfirmButton: false,
		  timer: 1500
		})
		return false;
	}
	else if(isNaN(cantidadservicio)) {
		Swal.fire({
		  position: 'top-end',
		  icon: 'warning',
		  title: 'La cantidad servicio ingresada no es numero',
		  showConfirmButton: false,
		  timer: 1500
		})
		return false;
	}
	else if(isNaN(valortota)) {
		Swal.fire({
		  position: 'top-end',
		  icon: 'warning',
		  title: 'El valor total ingresado no es numero',
		  showConfirmButton: false,
		  timer: 1500
		})
		return false;
	}else{
		enviar(event);
	}
}

function validarforagenda(event) {
	var horainicio, horafin, nombrecliente, correocliente, telefonocliente, estado, serviciosolicitado;
	horainicio = document.getElementById("horainicio").value;
	horafin = document.getElementById("horafin").value;
	nombrecliente = document.getElementById("nombrecliente").value;
	correocliente = document.getElementById("correocliente").value;
	telefonocliente = document.getElementById("telefonocliente").value;
	estado = document.getElementById("estado").value;
	serviciosolicitado = document.getElementById("serviciosolicitado").value;
	
	if(horainicio === "" || horafin === "" || nombrecliente === "" || correocliente === "" || telefonocliente === "" || estado === "" || serviciosolicitado === ""){
		Swal.fire(
		'Te falta un campo?',
  		'!Todos los campos son obligatorios!',
  		'question'
		)
		return false;
	}
	else if(horainicio.length>30) {
		Swal.fire({
		  position: 'top-end',
		  icon: 'warning',
		  title: 'La hora inicio es muy larga',
		  showConfirmButton: false,
		  timer: 1500
		})
		return false;
	}
	else if(horafin.length>30) {
		Swal.fire({
		  position: 'top-end',
		  icon: 'warning',
		  title: 'La hora fin es muy larga',
		  showConfirmButton: false,
		  timer: 1500
		})
		return false;
	}
	else if(nombrecliente.length>10) {
		Swal.fire({
		  position: 'top-end',
		  icon: 'warning',
		  title: 'El nombre cliente es muy largo',
		  showConfirmButton: false,
		  timer: 1500
		})
		return false;
	}
	else if((ValidateEmail(correocliente))) {
		Swal.fire({
		  position: 'top-end',
		  icon: 'warning',
		  title: 'El correo esta mal',
		  showConfirmButton: false,
		  timer: 1500
		})
		return false;
	}
	else if(telefonocliente.length>10) {
		Swal.fire({
		  position: 'top-end',
		  icon: 'warning',
		  title: 'No has seleccionado el campo',
		  showConfirmButton: false,
		  timer: 1500
		})
		return false;
	}
	else if(estado.length>10) {
		Swal.fire({
		  position: 'top-end',
		  icon: 'warning',
		  title: 'No has seleccionado el campo',
		  showConfirmButton: false,
		  timer: 1500
		})
		return false;
	}
	else if(serviciosolicitado.length>10) {
		Swal.fire({
		  position: 'top-end',
		  icon: 'warning',
		  title: 'El servicio solicitado es muy largo',
		  showConfirmButton: false,
		  timer: 1500
		})
		return false;
	}
	else if(isNaN(horainicio)) {
		Swal.fire({
		  position: 'top-end',
		  icon: 'warning',
		  title: 'La hora inicio ingresada no es numero',
		  showConfirmButton: false,
		  timer: 1500
		})
		return false;
	}
	else if(isNaN(horafin)) {
		Swal.fire({
		  position: 'top-end',
		  icon: 'warning',
		  title: 'La hora inicio ingresada no es numero',
		  showConfirmButton: false,
		  timer: 1500
		})
		return false;
	}
	else if(isNaN(telefonocliente)) {
		Swal.fire({
		  position: 'top-end',
		  icon: 'warning',
		  title: 'El telefono cliente ingresado no es numero',
		  showConfirmButton: false,
		  timer: 1500
		})
		return false;
	}else{
		enviar(event);
	}
}

function validarforcotizacion(event) {
	event.preventDefault();
	var estado, nombrecliente, apellidocliente, cedulacliente, email, cantidadproducto, valorservicio, mensaje;
	estado = document.getElementById("estado").value;
	nombrecliente = document.getElementById("nombrecliente").value;
	apellidocliente = document.getElementById("apellidocliente").value;
	cedulacliente = document.getElementById("cedulacliente").value;
	email = document.getElementById("email").value;
	cantidadproducto = document.getElementById("cantidadproducto").value;
	valorservicio = document.getElementById("valorservicio").value;
	mensaje = document.getElementById("mensaje");
	
	if(estado === "" || nombrecliente === "" || apellidocliente === "" || cedulacliente === "" || email === "" || cantidadproducto === "" || valorservicio === "" || mensaje === ""){
		Swal.fire(
		'Te falta un campo?',
  		'!Todos los campos son obligatorios!',
  		'question'
		)
		return false;
	}
	else if(estado.length>30) {
		Swal.fire({
		  position: 'top-end',
		  icon: 'warning',
		  title: 'Selecciona una Opcion',
		  showConfirmButton: false,
		  timer: 1500
		})
		return false;
	}
	else if(nombrecliente.length>30) {
		Swal.fire({
		  position: 'top-end',
		  icon: 'warning',
		  title: 'El nombre cliente es muy largo',
		  showConfirmButton: false,
		  timer: 1500
		})
		return false;
	}
	else if(nombrecliente.length>10) {
		Swal.fire({
		  position: 'top-end',
		  icon: 'warning',
		  title: 'El nombre cliente es muy largo',
		  showConfirmButton: false,
		  timer: 1500
		})
		return false;
	}
	else if(apellidocliente.length>10) {
		Swal.fire({
		  position: 'top-end',
		  icon: 'warning',
		  title: 'El apellido cliente es muy largo',
		  showConfirmButton: false,
		  timer: 1500
		})
		return false;
	}
	else if(cedulacliente.length>10) {
		Swal.fire({
		  position: 'top-end',
		  icon: 'warning',
		  title: 'La cedula cliente es muy larga',
		  showConfirmButton: false,
		  timer: 1500
		})
		return false;
	}
	else if(ValidateEmail(email)) {
		Swal.fire({
		  position: 'top-end',
		  icon: 'warning',
		  title: 'El correo esta mal',
		  showConfirmButton: false,
		  timer: 1500
		})
		return false;
	}
	else if(cantidadproducto.length>10) {
		Swal.fire({
		  position: 'top-end',
		  icon: 'warning',
		  title: 'El cantidad producto es muy largo',
		  showConfirmButton: false,
		  timer: 1500
		})
		return false;
	}
	else if(valorservicio.length>10) {
		Swal.fire({
		  position: 'top-end',
		  icon: 'warning',
		  title: 'El valor servicio es muy largo',
		  showConfirmButton: false,
		  timer: 1500
		})
		return false;
	}
	else if(mensaje.length>250) {
		Swal.fire({
		  position: 'top-end',
		  icon: 'warning',
		  title: 'El cantidad producto es muy largo',
		  showConfirmButton: false,
		  timer: 1500
		})
		return false;
	}
	else if(isNaN(cedulacliente)) {
		Swal.fire({
		  position: 'top-end',
		  icon: 'warning',
		  title: 'La cedula ingresada no es numero',
		  showConfirmButton: false,
		  timer: 1500
		})
		return false;
	}
	else if(isNaN(cantidadproducto)) {
		Swal.fire({
		  position: 'top-end',
		  icon: 'warning',
		  title: 'El cantidad producto ingresado no es numero',
		  showConfirmButton: false,
		  timer: 1500
		})
		return false;
	}
	else if(isNaN(valorservicio)) {
		Swal.fire({
		  position: 'top-end',
		  icon: 'error',
		  title: 'La cantidad ingresada no es numero',
		  showConfirmButton: false,
		  timer: 1500
		})
		return false;
	}else{
		enviar(event);
	
	}
}

function ValidateEmail(mail) 
{
 if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(mail))
  {
    return (false)
  }
    return (true)
}

function validacionFormLogin() {
	
	valorUsuario = document.getElementById("txtUsuario").value;
	valorPassword = document.getElementById("txtPassword").value;
	
	// validacion para campos vacios
	if (valorUsuario == null || valorUsuario.length == 0 || /^\s+$/.test(valorUsuario)) {
		Swal.fire({
			  position: 'top-end',
			  icon: 'warning',
			  title: 'Por favor ingrese un usuario',
			  showConfirmButton: false,
			  timer: 1500
			})
			return false;
	}

	if (valorPassword == null || valorPassword.length == 0 || /^\s+$/.test(valorPassword)) {
		Swal.fire({
			  position: 'top-end',
			  icon: 'warning',
			  title: 'Por favor ingrese una contraseña',
			  showConfirmButton: false,
			  timer: 1500
			})
			return false;
	}

	return true;
}
