
/**
 * PortfolioServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package core.sakai.wsdl;

    /**
     *  PortfolioServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class PortfolioServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public PortfolioServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public PortfolioServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for getSitePublicPortfolios method
            * override this method for handling normal response from getSitePublicPortfolios operation
            */
           public void receiveResultgetSitePublicPortfolios(
                    core.sakai.wsdl.PortfolioServiceStub.GetSitePublicPortfoliosResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getSitePublicPortfolios operation
           */
            public void receiveErrorgetSitePublicPortfolios(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getPortfolioOptions method
            * override this method for handling normal response from getPortfolioOptions operation
            */
           public void receiveResultgetPortfolioOptions(
                    core.sakai.wsdl.PortfolioServiceStub.GetPortfolioOptionsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getPortfolioOptions operation
           */
            public void receiveErrorgetPortfolioOptions(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getAllPublicPortfolios method
            * override this method for handling normal response from getAllPublicPortfolios operation
            */
           public void receiveResultgetAllPublicPortfolios(
                    core.sakai.wsdl.PortfolioServiceStub.GetAllPublicPortfoliosResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAllPublicPortfolios operation
           */
            public void receiveErrorgetAllPublicPortfolios(java.lang.Exception e) {
            }
                


    }
    