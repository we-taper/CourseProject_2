
/**
 * SakaiSigningServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package core.sakai.wsdl;

    /**
     *  SakaiSigningServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class SakaiSigningServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public SakaiSigningServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public SakaiSigningServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for hex2Byte method
            * override this method for handling normal response from hex2Byte operation
            */
           public void receiveResulthex2Byte(
                    core.sakai.wsdl.SakaiSigningServiceStub.Hex2ByteResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from hex2Byte operation
           */
            public void receiveErrorhex2Byte(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for testsign method
            * override this method for handling normal response from testsign operation
            */
           public void receiveResulttestsign(
                    core.sakai.wsdl.SakaiSigningServiceStub.TestsignResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from testsign operation
           */
            public void receiveErrortestsign(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for touchsession method
            * override this method for handling normal response from touchsession operation
            */
           public void receiveResulttouchsession(
                    core.sakai.wsdl.SakaiSigningServiceStub.TouchsessionResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from touchsession operation
           */
            public void receiveErrortouchsession(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for verifysign method
            * override this method for handling normal response from verifysign operation
            */
           public void receiveResultverifysign(
                    core.sakai.wsdl.SakaiSigningServiceStub.VerifysignResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from verifysign operation
           */
            public void receiveErrorverifysign(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getsession method
            * override this method for handling normal response from getsession operation
            */
           public void receiveResultgetsession(
                    core.sakai.wsdl.SakaiSigningServiceStub.GetsessionResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getsession operation
           */
            public void receiveErrorgetsession(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getSessionToServer method
            * override this method for handling normal response from getSessionToServer operation
            */
           public void receiveResultgetSessionToServer(
                    core.sakai.wsdl.SakaiSigningServiceStub.GetSessionToServerResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getSessionToServer operation
           */
            public void receiveErrorgetSessionToServer(java.lang.Exception e) {
            }
                


    }
    