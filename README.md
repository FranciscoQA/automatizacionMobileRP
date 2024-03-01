#MOBILE EXAMPLE

Este proyecto es un Sistema de Automatización de Pruebas (SAP). Basado en Appium y utilizandando
el framework de Serentiy BDD para gestionar las propiedades de ejecución y otras características 
propias del framwork.

##Pre requisitos
    1.- Tener instalado Appium Desktop version > 1.18.x
    2.- Tener configurado Maven
    3.- Tener configuradas las variables de entorno:

 ```
 - M2_HOME
 - JAVA_HOME
 ```
   
###Android: 
    1.- Tener instalado el SDK de Android, de preferencia instalar Android Studio para descargar todo lo necesario
    2.- Tener configuradas las variables de entorno:

 ```
  - ANDROID_HOME
  - ANDROID_HOME/platform-tools
  - ANDROID_HOME/tools
  - ANDROID_HOME/tools/bin
 ```

###iOS
    1.- Tener un entorno Mac OS 
    2.- Tener instalado el SDK de iOS, de preferencia instalar XCode para descargar todo lo necesario.
    
##Distribución

| Objectos | Descripcion |
| ---- | ----|
| features | Ficheros que soportan el lenguaje de comportamiento Gherkin, donde estaran redactados los escenarios |
| RunnerTest | Clase que realiza la ejecucion de una prueba a través de un TAG |
| StepDefinition | Clase donde están implementados los "steps" de los escenarios redactados en Gherkin |
| Step | Clase intermedia entre la implemtación de los StepDefinition y las clases de tipo PageObject |
| Views | Clases de tipo PageObject, utilizadas para representar el concepto básico del patrón de diseño Page Object |
| Util | Clase utilitaria, con metodos desacoplados de la prueba |
| Contants | Clase que contiene constantes utilizadas en la SAP |
| serenity.conf | Fichero de configuracion que, pertenece al modelo operativo del framework Serenity BDD, contiene la declaracion y distribucion de ambientes |
| serenity.properties | Fichero de propiedad que, contiene todas las propiedades que serán utilizadas en la ejecución de la SAP |

##Modo de uso

    0 Ingresar las propiedades necesarias en el fichero serenity.properties
    1 Redacción de los escenarios en gherkin en los .feature
    2 Definición de los pasos en el StepDefinition
        2.1 Llamar al metodo que instancia y crea el driver de tipo AppiumDriver con todas las capabilities 
        seteadas en el serenity.properties
        
       ´´´
       MobileDriverManager mobileDriverManager = new MobileDriverManager(environmentVariables);
       mobileDriverManager.setMobileDriver();
       ´´´
        
    3 Creación de los metodos del paso a paso que se implementaran en los StepDefinition
    4 Creación de los PageObject
        4.1 Extencion de la clase MobileDriverDom, del Jar <mobile-continuous-testing>
        
        ´´´
        public class FuncionalidadView extends MobileDriverDom {}
        ´´´
        
        4.2 Identificación de los componentes visuales por cada pantalla (Views), utilizando las anotaciones PageFactory 
        (@AndroidFindBy, @iOSXCUITFindBy)
        4.3 Creacion de metodos de "accion" en los componentes visuales identificados
    
###serenity.properties
    
    ####### SAUCELABS #######
    sauceLabs=false
    sauceLabsUser=pmendozz
    sauceLabsAccessKey=8dfa6f90-2d14-42a8-81a7-47952f4da009
    sauceLabsHub=@ondemand.us-west-1.saucelabs.com:443/wd/hub
    tunnelIdentifier=
    sauceLabs.platformName=Android
    sauceLabs.platformVersion=11
    sauceLabs.deviceName=Google_Pixel_5_bankperu_us
    sauceLabs.appPath=storage:59fb93a2-a15f-44f0-a093-f1273fe3440f
    enableAnimations=true
    privateDevicesOnly=true
    
* sauceLabs:

    ```
    - true, para activar se hace por SauceLabs.
    - false, para desactivar la ejecucion por Saucelabs.
    ```
  
* sauceLabsUser: Propiedad en la cuenta de SauceLabs.
* sauceLabsAccessKey: Propiedad en la cuenta de SauceLabs.
* sauceLabsHub: Propiedad en la cuenta de SauceLabs.
* tunnelIdentifier: identificador del Tuner de seguridad, SauceConnect.

    ```
    <vacio "">, si no se tienen ningun Tunel de seguridad activo, SauceConnect.
    ```

* sauceLabs.platformName: <Android | iOS>
* sauceLabs.platformVersion: Version del equipo de la granja donde se va a ejecutar
* sauceLabs.deviceName: Identificador unico del equipo de la granja donde se va a ejecutar
* sauceLabs.appPath: 

    ```
    - storage:59fb93a2-a15f-44f0-a093-f1273fe3440f -> Identificador de el aplicativo subido en SauceLabs
    - Url de descarga del aplicativo que se desea instalar
    ```

* enableAnimations: Para Android, siempre <true>
* privateDevicesOnly: Para Android, siempre <true>
        

    ####### ANDROID PROPERTIES #######
    appiumHub=http://127.0.0.1:4723/wd/hub
    automationName=UIAutomator2
    platformName=Android
    platformVersion=10
    deviceName=Xiaomi_A3
    appPath=
    udid=de780a771e67
    appPackage=com.bcp.bank.bcp.beta
    appLaunchActivity=com.bcp.bank.bcp.splash.SplashActivity
    resetApp=false
    
    
* appiumHub: Hub local o remoto de Appium

    ```
    formato:  http://<ip_host>:<port>/wd/hub
    ```

* automationName: Motor de automatización y ejecución

    ```
    - Android: UIAutomator
    - iOS: XCUITest
    ```

* platformName: <Android | iOS >
* platformVersion: Versión del Sistema Operativo
* deviceName: Nombre del dispositivo
* appPath= 

    ```
    - <vacio "">, si el aplicativo ya se encuntra instalado.
    - Ruta local de la ubicación del aplicativo (iOS: .app .ipa, Android: .apk)
    - Url de descarga del aplicativo que se desea instalar 
    ```

* udid: Identificador unico del dispositivo

    ```
    Para ubicarlo, Android:
     $ adb devices -l
  
    iOS:
     $ instruments -s devices
    ```
  
* noResetApp: 

    ```
    - true, no reinicia el app en cada ejecución
    - false, reincia el app en cada ejecución
    ```
  
####Solo Android
* appPackage: Paquete del .apk
  * appLaunchActivity: Actividad con la que inicia el aplicativo. Por lo general siempre es un Splash

      ```
      Para obtener estos valores, ejecutar:
       $ adb shell dumpsys window | find "mCurrentFocus"
       $ adb shell "dumpsys window | grep mCurrentFocus"
       $ adb shell settings get secure android_id
      ```
  

