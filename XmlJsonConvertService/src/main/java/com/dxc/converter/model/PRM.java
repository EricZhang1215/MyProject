
package com.dxc.converter.model;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "PRM", targetNamespace = "http://www.csc.smart/bo/services/PRM")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface PRM {


    /**
     * 
     * @param prmcalrq
     * @return
     *     returns com.dxc.converter.api.PRM.PRMCALOREC
     */
    @WebMethod(operationName = "PRMCAL", action = "PRMCALAction")
    @WebResult(name = "PRMCALO_REC", targetNamespace = "http://www.csc.smart/bo/schemas/PRMCALO", partName = "PRMCALRS")
    public PRMCALOREC prmcal(
        @WebParam(name = "PRMCALI_REC", targetNamespace = "http://www.csc.smart/bo/schemas/PRMCALI", partName = "PRMCALRQ")
        PRMCALIREC prmcalrq);

}
