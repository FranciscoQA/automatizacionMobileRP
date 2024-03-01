package com.bdd.step;
import com.bdd.view.*;
import io.cucumber.datatable.DataTable;
import mobile.com.bdd.lib.MobileDriverManager;
import mobile.com.bdd.util.UtilMobile;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class RealPlazaSteps {
    public RealPlazaView realPlazaView(){
        return new RealPlazaView();
    }

    @Step("Buscar boton registro")
    public void visualizoElLoginDeRealPlazaSeleccionoElBoton(String btnLogin) {
        realPlazaView().visualizoElLoginDeRealPlazaSeleccionoElBoton(btnLogin);

    }
    @Step("Selecciono una opcion de registro")
    public void seleccionoUnaManeraDeRegistrarseALaApp(String btnOpcionRegistro) {
        realPlazaView().seleccionoUnaManeraDeRegistrarseALaApp(btnOpcionRegistro);
    }
    @Step("Seleciono un correo")
    public void seleccionoUnCorreo(DataTable dataTable) {
        String correo= UtilMobile.getValueFromDataTable(dataTable,"sCorreo");
        realPlazaView().seleccionoUnCorreo(correo);

    }

    @Step("Seleciono boton continuar")
    public void seleccionoElBotonContinuar() {
        realPlazaView().seleccionoElBotonContinuar();
    }

    @Step("se mostrará el titulo del inicio de la app")
    public void validoQueEstoyEnElIncioDeLaApp() {
        realPlazaView().validoQueEstoyEnElIncioDeLaApp();
    }

    @Step("doy click en eventos y sorteos")
    public void leDoyClickEnLaOpcion(String opcion) {
        realPlazaView().leDoyClickEnLaOpcion(opcion);
    }

    public void cierroElAnuncio() {
        realPlazaView().cierroElAnuncio();
    }

    public void validoQueEstoyEnLaSeccion(String sSeccion) {
        realPlazaView().validoQueEstoyEnLaSeccion(sSeccion);
    }
}
