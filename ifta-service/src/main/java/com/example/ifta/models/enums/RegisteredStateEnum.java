package com.example.ifta.models.enums;

import java.util.ArrayList;
import java.util.List;

public enum RegisteredStateEnum {

    AL("AL", "Alabama"),
    AK("AK", "Alaska"),
    AZ("AZ", "Arizona"),
    AR("AR", "Arkansas"),
    CA("CA", "California"),
    CO("CO", "Colorado"),
    CT("CT", "Connecticut"),
    DE("DE", "Delaware"),
    DC("DC", "Dist of Col"),
    GA("GA", "Georgia"),
    HI("HI", "Hawaii"),
    ID("ID", "Idaho"),
    IL("IL", "Illinois"),
    IN("IN", "Indiana"),
    IA("IA", "Iowa"),
    KS("KS", "Kansas"),
    KY("KY", "Kentucky"),
    LA("LA", "Louisiana"),
    ME("ME", "Maine"),
    MD("MD", "Maryland"),
    MA("MA", "Massachusetts"),
    MI("MI", "Michigan"),
    MN("MN", "Minnesota"),
    MS("MS", "Mississippi"),
    MO("MO", "Missouri"),
    MT("MT", "Montana"),
    NE("NE", "Nebraska"),
    NV("NV", "Nevada"),
    NH("NH", "New Hampshire"),
    NJ("NJ", "New Jersey"),
    NM("NM", "New Mexico"),
    NY("NY", "New York"),
    NC("NC", "North Carolina"),
    ND("ND", "North Dakota"),
    OH("OH", "Ohio"),
    OK("OK", "Oklahoma"),
    OR("OR", "Oregon"),
    PA("PA", "Pennsylvania"),
    RI("RI", "Rhode Island"),
    SC("SC", "South Carolina"),
    SD("SD", "South Dakota"),
    TN("TN", "Tennessee"),
    TX("TX", "Texas"),
    UT("UT", "Utah"),
    VT("VT", "Vermont"),
    VA("VA", "Virginia"),
    WA("WA", "Washington"),
    WV("WV", "West Virginia"),
    WI("WI", "Wisconsin"),
    WY("WY", "Wyoming"),
    AS("AS", "American Samoa"),
    GU("GU", "Guam"),
    MP("MP", "Northern Marianas"),
    PR("PR", "Puerto Rico"),
    VI("VI", "Virgin Islands"),
    AB("AB", "Alberta"),
    BC("BC", "British Columbia"),
    MB("MB", "Manitoba"),
    NB("NB", "New Brunswick"),
    NF("NF", "Newfoundland"),
    NS("NS", "Nova Scotia"),
    NT("NT", "Northwest Territories"),
    ON("ON", "Ontario"),
    PE("PE", "Prince Edward Island"),
    QC("QC", "Quebec"),
    SK("SK", "Saskatchewan"),
    YT("YT", "Yukon Territory"),
    AG("AG", "Aguascalientes"),
    BN("BN", "Baja California Norte"),
    BS("BS", "Baja California Sur"),
    CH("CH", "Coahila"),
    CI("CI", "Chihuahua"),
    CL("CL", "Colima"),
    CP("CP", "Campeche"),
    CS("CS", "Chiapas"),
    DF("DF", "Districto Federal"),
    DG("DG", "Durango"),
    GE("GE", "Guerrero"),
    GJ("GJ", "Guanajuato"),
    HD("HD", "Hidalgo"),
    JA("JA", "Jalisco"),
    MC("MC", "Michoacan"),
    MR("MR", "Morelos"),
    MX("MX", "Mexico"),
    NA("NA", "Nayarit"),
    NL("NL", "Nuevo Leon"),
    OA("OA", "Oaxaca"),
    PU("PU", "Puebla"),
    QE("QE", "Queretaro"),
    QI("QI", "Quintana Roo"),
    SI("SI", "Sinaloa"),
    SL("SL", "San Luis Potosi"),
    SO("SO", "Sonora"),
    TA("TA", "Tamaulipas"),
    TB("TB", "Tabasco"),
    TL("TL", "Tlaxcala"),
    VC("VC", "Veracruz"),
    YU("YU", "Yucatan"),
    ZA("ZA", "Zacatecas"),
    OT("OT", "Other"),
    FL("FL", "Florida");

    private String code;
    private String name;
    private static List<String> codes;
    private static List<String> names;

    RegisteredStateEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    static {
        codes = new ArrayList<>();
        codes.add(AL.getCode());
        codes.add(AK.getCode());
        codes.add(AZ.getCode());
        codes.add(AR.getCode());
        codes.add(CA.getCode());
        codes.add(CO.getCode());
        codes.add(CT.getCode());
        codes.add(DE.getCode());
        codes.add(DC.getCode());
        codes.add(GA.getCode());
        codes.add(HI.getCode());
        codes.add(ID.getCode());
        codes.add(IL.getCode());
        codes.add(IN.getCode());
        codes.add(IA.getCode());
        codes.add(KS.getCode());
        codes.add(KY.getCode());
        codes.add(LA.getCode());
        codes.add(ME.getCode());
        codes.add(MD.getCode());
        codes.add(MA.getCode());
        codes.add(MI.getCode());
        codes.add(MN.getCode());
        codes.add(MS.getCode());
        codes.add(MO.getCode());
        codes.add(MT.getCode());
        codes.add(NE.getCode());
        codes.add(NV.getCode());
        codes.add(NH.getCode());
        codes.add(NJ.getCode());
        codes.add(NM.getCode());
        codes.add(NY.getCode());
        codes.add(NC.getCode());
        codes.add(ND.getCode());
        codes.add(OH.getCode());
        codes.add(OK.getCode());
        codes.add(OR.getCode());
        codes.add(PA.getCode());
        codes.add(RI.getCode());
        codes.add(SC.getCode());
        codes.add(SD.getCode());
        codes.add(TN.getCode());
        codes.add(TX.getCode());
        codes.add(UT.getCode());
        codes.add(VT.getCode());
        codes.add(VA.getCode());
        codes.add(WA.getCode());
        codes.add(WV.getCode());
        codes.add(WI.getCode());
        codes.add(WY.getCode());
        codes.add(AS.getCode());
        codes.add(GU.getCode());
        codes.add(MP.getCode());
        codes.add(PR.getCode());
        codes.add(VI.getCode());
        codes.add(AB.getCode());
        codes.add(BC.getCode());
        codes.add(MB.getCode());
        codes.add(NB.getCode());
        codes.add(NF.getCode());
        codes.add(NS.getCode());
        codes.add(NT.getCode());
        codes.add(ON.getCode());
        codes.add(PE.getCode());
        codes.add(QC.getCode());
        codes.add(SK.getCode());
        codes.add(YT.getCode());
        codes.add(AG.getCode());
        codes.add(BN.getCode());
        codes.add(BS.getCode());
        codes.add(CH.getCode());
        codes.add(CI.getCode());
        codes.add(CL.getCode());
        codes.add(CP.getCode());
        codes.add(CS.getCode());
        codes.add(DF.getCode());
        codes.add(DG.getCode());
        codes.add(GE.getCode());
        codes.add(GJ.getCode());
        codes.add(HD.getCode());
        codes.add(JA.getCode());
        codes.add(MC.getCode());
        codes.add(MR.getCode());
        codes.add(MX.getCode());
        codes.add(NA.getCode());
        codes.add(NL.getCode());
        codes.add(OA.getCode());
        codes.add(PU.getCode());
        codes.add(QE.getCode());
        codes.add(QI.getCode());
        codes.add(SI.getCode());
        codes.add(SL.getCode());
        codes.add(SO.getCode());
        codes.add(TA.getCode());
        codes.add(TB.getCode());
        codes.add(TL.getCode());
        codes.add(VC.getCode());
        codes.add(YU.getCode());
        codes.add(ZA.getCode());
        codes.add(OT.getCode());
        codes.add(FL.getCode());
        names = new ArrayList<>();
        names.add(AL.getName());
        names.add(AK.getName());
        names.add(AZ.getName());
        names.add(AR.getName());
        names.add(CA.getName());
        names.add(CO.getName());
        names.add(CT.getName());
        names.add(DE.getName());
        names.add(DC.getName());
        names.add(GA.getName());
        names.add(HI.getName());
        names.add(ID.getName());
        names.add(IL.getName());
        names.add(IN.getName());
        names.add(IA.getName());
        names.add(KS.getName());
        names.add(KY.getName());
        names.add(LA.getName());
        names.add(ME.getName());
        names.add(MD.getName());
        names.add(MA.getName());
        names.add(MI.getName());
        names.add(MN.getName());
        names.add(MS.getName());
        names.add(MO.getName());
        names.add(MT.getName());
        names.add(NE.getName());
        names.add(NV.getName());
        names.add(NH.getName());
        names.add(NJ.getName());
        names.add(NM.getName());
        names.add(NY.getName());
        names.add(NC.getName());
        names.add(ND.getName());
        names.add(OH.getName());
        names.add(OK.getName());
        names.add(OR.getName());
        names.add(PA.getName());
        names.add(RI.getName());
        names.add(SC.getName());
        names.add(SD.getName());
        names.add(TN.getName());
        names.add(TX.getName());
        names.add(UT.getName());
        names.add(VT.getName());
        names.add(VA.getName());
        names.add(WA.getName());
        names.add(WV.getName());
        names.add(WI.getName());
        names.add(WY.getName());
        names.add(AS.getName());
        names.add(GU.getName());
        names.add(MP.getName());
        names.add(PR.getName());
        names.add(VI.getName());
        names.add(AB.getName());
        names.add(BC.getName());
        names.add(MB.getName());
        names.add(NB.getName());
        names.add(NF.getName());
        names.add(NS.getName());
        names.add(NT.getName());
        names.add(ON.getName());
        names.add(PE.getName());
        names.add(QC.getName());
        names.add(SK.getName());
        names.add(YT.getName());
        names.add(AG.getName());
        names.add(BN.getName());
        names.add(BS.getName());
        names.add(CH.getName());
        names.add(CI.getName());
        names.add(CL.getName());
        names.add(CP.getName());
        names.add(CS.getName());
        names.add(DF.getName());
        names.add(DG.getName());
        names.add(GE.getName());
        names.add(GJ.getName());
        names.add(HD.getName());
        names.add(JA.getName());
        names.add(MC.getName());
        names.add(MR.getName());
        names.add(MX.getName());
        names.add(NA.getName());
        names.add(NL.getName());
        names.add(OA.getName());
        names.add(PU.getName());
        names.add(QE.getName());
        names.add(QI.getName());
        names.add(SI.getName());
        names.add(SL.getName());
        names.add(SO.getName());
        names.add(TA.getName());
        names.add(TB.getName());
        names.add(TL.getName());
        names.add(VC.getName());
        names.add(YU.getName());
        names.add(ZA.getName());
        names.add(OT.getName());
        names.add(FL.getName());
    }

    public static List<String> getCodeList() {
        return codes;
    }

    public static List<String> getNameList() {
        return names;
    }

}
