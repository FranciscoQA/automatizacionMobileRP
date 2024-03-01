#language: es
@REALPLAZA_APPS
Característica: Login a RealPlaza

  Antecedentes:
    Dado que cargo el aplicativo RealPlazaApp

  @LOGIN_REAL_PLAZA
  Esquema del escenario: Ingreso los datos personales para loguearme en la App
    Cuando visualizo el login de Real Plaza selecciono el boton "REGISTRARME"
    Y selecciono una manera de registrarse a la app "Ingresar con Google"
    Y selecciono un correo
      | sCorreo   |
      | <sCorreo> |
    Y selecciono el boton continuar
    Y cierro el anuncio
    Y le doy click en la opcion "Eventos y sorteos"
    Entonces valido que estoy en la seccion "Eventos y sorteos"
    Ejemplos:
      | sCorreo            |
      | fj069391@gmail.com |

