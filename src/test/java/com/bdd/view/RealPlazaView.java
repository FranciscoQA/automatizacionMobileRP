package com.bdd.view;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.offset.PointOption;
import mobile.com.bdd.generic.MobileDriverDom;
import mobile.com.bdd.lib.MobileDriverManager;
import mobile.com.bdd.util.UtilMobile;

import java.util.List;
import java.util.Locale;
import java.util.logging.Level;

public class RealPlazaView extends MobileDriverDom {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Ingresar con Google']")
    private MobileElement btnRegistrarse;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Continuar']")
    private MobileElement btnContinuar;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView")
    private MobileElement txtInicio;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView")
    private MobileElement opcionTarjeta;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Eventos y Sorteos']")
    private MobileElement validarModuloEventos;


    @AndroidFindBy(xpath = "//android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup")
    private MobileElement cerrarAnuncio;

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
    private List<MobileElement> btnlstLogin;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
    private List<MobileElement> listOpcionRegistro;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[2]")
    private List<MobileElement> listCorreos;


    public void visualizoElLoginDeRealPlazaSeleccionoElBoton(String btnLogin) {
        //   cambiarTiempoDeEsperaImplicito(2000);
        UtilMobile.logger(this.getClass()).log(Level.INFO, "Seleccionando boton...", btnLogin);
        // waitUntilVisibilityElement(40, btnlstLogin.get(1));
        //  System.out.println(btnlstLogin.get(1).getText());
        try {
            for (MobileElement element : btnlstLogin) {
                if (element.getText().toLowerCase(Locale.ROOT).trim().contains(btnLogin.toLowerCase(Locale.ROOT).trim())) {
                    waitUntilVisibilityElement(40, element);
                    System.out.println(element.getText());
                    System.out.println("si encontro el boton");
                    clickElement(element);
                    break;
                } else {
                    System.out.println("no ingresa");
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }


    }

    public void seleccionoUnaManeraDeRegistrarseALaApp(String btnOpcionRegistro) {
        UtilMobile.logger(this.getClass()).log(Level.INFO, "Seleccionando Opcion de Registro...", btnOpcionRegistro);
        //   waitUntilVisibilityElement(30, listOpcionRegistro.get(1));
        // System.out.println(listOpcionRegistro.get(1).getText());
        // cambiarTiempoDeEsperaImplicito(100);
        try {
            for (MobileElement element : listOpcionRegistro) {
                if (element.getText().toLowerCase(Locale.ROOT).trim().contains(btnOpcionRegistro.toLowerCase(Locale.ROOT).trim())) {
                    clickElement(element);
                    break;
                }
            }

        } catch (Exception e) {
            System.out.printf(e.toString());
        }

    }

    public void seleccionoUnCorreo(String correo) {

        UtilMobile.logger(this.getClass()).log(Level.INFO, "Seleccionando correo...", correo);
        waitUntilVisibilityElement(15, listCorreos.get(1));
        try {
            for (MobileElement element : listCorreos) {
                if (element.getText().equals(correo)) {
                    clickElement(element);
                    break;
                }

            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }

    public void seleccionoElBotonContinuar() {
        UtilMobile.logger(this.getClass()).log(Level.INFO, "Seleccionando correo...", btnContinuar);
        try {
            if (waitUntilVisibilityElement(10, btnContinuar).isDisplayed()) {
                clickElement(btnContinuar);
            }

        } catch (Exception e) {
            System.out.printf(e.toString());
        }


    }

    public void validoQueEstoyEnElIncioDeLaApp() {
        UtilMobile.logger(this.getClass()).log(Level.INFO, "Capturo mensaje de inicio");
        waitUntilVisibilityElement(20, txtInicio);
        UtilMobile.logger(this.getClass()).log(Level.INFO, "El mensaje de validacion es {0}", getText(txtInicio));

    }

    public void leDoyClickEnLaOpcion(String opcion) {
        waitUntilVisibilityElement(30, opcionTarjeta);
        moveFromElementToElement(opcionTarjeta);
        clickElement(opcionTarjeta);

    }

    public void cierroElAnuncio() {
        UtilMobile.logger(this.getClass()).log(Level.INFO, "Cerrando anuncio...", cerrarAnuncio);
        waitUntilVisibilityElement(40, cerrarAnuncio);
        try {
            waitUntilVisibilityElement(60, cerrarAnuncio);
            clickElement(cerrarAnuncio);
        } catch (Exception e) {
            System.out.printf(e.toString());
        }

    }

    protected void moveFromElementToElement(MobileElement elementinicial) {
        int posicionInicialX = elementinicial.getLocation().getX() + elementinicial.getSize().width / 2;
        int posicionInicialY = elementinicial.getLocation().getY() + elementinicial.getSize().height / 2;

        int posicionFinalX = MobileDriverManager.getMobileDriver().manage().window().getSize().width / 2;
        int posicionFinalY = MobileDriverManager.getMobileDriver().manage().window().getSize().height / 2;

        TouchAction touchAction = new TouchAction(MobileDriverManager.getMobileDriver());
        touchAction.longPress(PointOption.point(posicionInicialX, posicionInicialY)).moveTo(PointOption.point(posicionFinalX, posicionFinalY)).release().perform();
    }

    public void validoQueEstoyEnLaSeccion(String sSeccion) {
        UtilMobile.logger(this.getClass()).log(Level.INFO, "Valido que estoy en el modulo Eventos y Sorteos");
        waitUntilVisibilityElement(20, validarModuloEventos);
        if (validarModuloEventos.getText().toLowerCase(Locale.ROOT).trim().contains(sSeccion.toLowerCase(Locale.ROOT).trim())) {
            UtilMobile.logger(this.getClass()).log(Level.INFO, "El mensaje de validacion es {0}", getText(validarModuloEventos));
        }


    }
}


