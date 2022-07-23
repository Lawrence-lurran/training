package com.nmu.training.domain.entity;

import java.util.Date;



import com.baomidou.mybatisplus.annotation.IdType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * (SamplingInformation)表实体类
 *
 * @author makejava
 * @since 2022-07-22 14:37:17
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sampling_information")
public class SamplingInformationDO  {


    @TableId(type = IdType.AUTO)
    private Long id;


    private Long userId;

    private String number;



    private String taskType;



    private String companyContacts;



    private String companyPhoneNumber;



    private String companyFax;



    private String companyPostalCode;



    private String location;



    private String locationSampleType;


    private String sampleLink;



    private String sampleLocation;



    private String locationType;



    private String companyName;



    private String companyLocation;



    private String businessLicense;



    private String legalRepresentative;



    private String phoneNumber;



    private String contacts;



    private String licenseType;



    private String licenseKey;



    private String enterpriseLicenseNumber;



    private String isImported;



    private String originCountry;



    private String enterpriseLocation;



    private String productName;



    private String productLocation;



    private String productPhoneNumber;



    private String isThirdPartyInformation;



    private String thirdPartyNature;



    private String thirdPartyLicense;



    private String thirdPartyLocation;


    private String thirdPartyName;



    private String thirdPartyAddress;



    private String thirdPartyPhoneNumber;



    private String sampleBarcode;



    private String sampleType;



    private String sampleSource;



    private String sampleAttribute;



    private String sampleName;



    private String sampleTrademark;



    private String packageClassification;


    private String specification;



    private String qualityGrade;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date manufactureDate;



    private String qualityPeriod;



    private String sampleBatchNumber;



    private String samplePrice;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date samplingDate;



    private String samplingMethod;



    private String storageConditions;



    private String executiveStandard;



    private String samplingBase;



    private String samplingQuantity;



    private String preparationSamplingQuantity;



    private String preparationSamplingUnit;



    private String wholeSampleRemarks;



    private String remarks;



    private String samplingPersonName;



    private String pictureId;



}