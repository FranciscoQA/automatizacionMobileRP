package com.bdd.stepdefinition;

import com.bdd.step.RealPlazaSteps;
import environment.ManageEnvironment;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import mobile.com.bdd.generic.Constants;
import mobile.com.bdd.lib.MobileDriverManager;
import mobile.com.bdd.util.UtilMobile;
import net.thucydides.core.annotations.Steps;

import java.net.MalformedURLException;

public class RealPlazaStepDefinition {
    private Scenario scenario;
    @Steps
    private RealPlazaSteps realPlazaSteps;
    @Before
    public void beforeLoginStepDefinition(Scenario scenario){
        this.scenario =scenario;
        UtilMobile.saveVariableOnSession(Constants.SCENARIO, this.scenario);
    }

    @After
    public void afterLoginStepDefinition(){
        if (this.scenario.isFailed())
            UtilMobile.takeScreenShotMobile(this.scenario, MobileDriverManager.getMobileDriver());
        if (MobileDriverManager.getMobileDriver() != null)
            MobileDriverManager.stopMobileDriver();
    }
    @Dado("^que cargo el aplicativo RealPlazaApp$")
    public void cargo_app_calculadora() throws MalformedURLException {
        UtilMobile.logger(this.getClass()).info("Cargando el aplicativo RealPlaza ...");
        MobileDriverManager.setMobileDriver(ManageEnvironment.getEnvironment());
        UtilMobile.takeScreenShotMobile(this.scenario, MobileDriverManager.getMobileDriver());

    }

    @Cuando("visualizo el login de Real Plaza selecciono el boton {string}")
    public void visualizoElLoginDeRealPlazaSeleccionoElBoton(String btnLogin) {
        realPlazaSteps.visualizoElLoginDeRealPlazaSeleccionoElBoton(btnLogin);
        UtilMobile.takeScreenShotMobile(this.scenario, MobileDriverManager.getMobileDriver());

    }

    @Y("selecciono una manera de registrarse a la app {string}")
    public void seleccionoUnaManeraDeRegistrarseALaApp(String btnOpcionRegistro) {
        realPlazaSteps.seleccionoUnaManeraDeRegistrarseALaApp(btnOpcionRegistro);
        UtilMobile.takeScreenShotMobile(this.scenario, MobileDriverManager.getMobileDriver());
    }

    @Y("selecciono un correo")
    public void seleccionoUnCorreo(DataTable dataTable) {
        realPlazaSteps.seleccionoUnCorreo(dataTable);
        UtilMobile.takeScreenShotMobile(this.scenario, MobileDriverManager.getMobileDriver());

    }

    @Y("selecciono el boton continuar")
    public void seleccionoElBotonContinuar() {
        realPlazaSteps.seleccionoElBotonContinuar();
        UtilMobile.takeScreenShotMobile(this.scenario, MobileDriverManager.getMobileDriver());
    }

    @Entonces("valido que estoy en el incio de la app")
    public void validoQueEstoyEnElIncioDeLaApp() {
        realPlazaSteps.validoQueEstoyEnElIncioDeLaApp();
        UtilMobile.takeScreenShotMobile(this.scenario, MobileDriverManager.getMobileDriver());

    }

    @Y("le doy click en la opcion {string}")
    public void leDoyClickEnLaOpcion(String opcion) {
        realPlazaSteps.leDoyClickEnLaOpcion(opcion);
        UtilMobile.takeScreenShotMobile(this.scenario, MobileDriverManager.getMobileDriver());
    }

    @Y("cierro el anuncio")
    public void cierroElAnuncio() {
        realPlazaSteps.cierroElAnuncio();
        UtilMobile.takeScreenShotMobile(this.scenario, MobileDriverManager.getMobileDriver());
    }

    @Entonces("valido que estoy en la seccion {string}")
    public void validoQueEstoyEnLaSeccion(String sSeccion) {
        realPlazaSteps.validoQueEstoyEnLaSeccion(sSeccion);
        UtilMobile.takeScreenShotMobile(this.scenario, MobileDriverManager.getMobileDriver());
    }
}
