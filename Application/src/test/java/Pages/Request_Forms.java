package Pages;

import org.openqa.selenium.By;

import HelpingPages.GlobalizedPage;

public class Request_Forms extends GlobalizedPage{

//	Unit/Organization Information
	public By TYPE_OF_EVENT_FIELD_LABEL = By.cssSelector("[for='TypeOfEvent']");
	public By TYPE_OF_EVENT_DROPDOWN_FIELD = By.cssSelector("#TypeOfEvent");
	public By DATE_PICKER = By.cssSelector("#ui-datepicker-div");
	public By START_DATE_FIELD_LABEL = By.cssSelector("#txtStartDate");
	public By START_DATE_FIELD_INPUT = By.cssSelector("#EventStartDate");
	public By END_DATE_FIELD_LABEL = By.cssSelector("[for='EventEndDate']");
	public By END_DATE_FIELD_INPUT = By.cssSelector("#EventEndDate");
	public By BRANCH_FIELD_LABEL = By.cssSelector("[for='UnitBranchId']");
	public By BRANCH_DROPDOWN_FIELD = By.cssSelector("#UnitBranchId");
	public By PRIMARY_UNIT_FIELD_LABEL = By.cssSelector("[for='PrimaryUnitOrganizationName']");
	public By PRIMARY_UNIT_FIELD_INPUT = By.cssSelector("#PrimaryUnitOrganizationName");
	public By UNIT_ADDRESS1_FIELD_LABEL = By.cssSelector("[for='UnitAddressLine1']");
	public By UNIT_ADDRESS1_FIELD_INPUT = By.cssSelector("#UnitAddressLine1");
	public By UNIT_ADDRESS2_FIELD_LABEL = By.cssSelector("[for='UnitAddressLine2']");
	public By UNIT_ADDRESS2_FIELD_INPUT = By.cssSelector("#UnitAddressLine2");
	public By CITY_INSTALLATION_FIELD_LABEL = By.cssSelector("[for='UnitCityId']");
	public By CITY_INSTALLATION_FIELD_INPUT = By.cssSelector("#UnitCityId");
	public By STATE_INSTALLATION_FIELD_LABEL = By.cssSelector("[for='UnitStateId']");
	public By STATE_INSTALLATION_FIELD_INPUT = By.cssSelector("#UnitStateId");
	public By UNIT_ZIP_CODE_FIELD_LABEL = By.cssSelector("[for='UnitZipCode']");
	public By UNIT_ZIP_CODE_FIELD_INPUT = By.cssSelector("[for='#UnitZipCode']");
	public By MULTIPLE_UNIT_FIELD_LABEL = By.cssSelector("[for='MultipleUnits_Yes'].control-label");
	public By MULTIPLE_UNIT_YES_RADIO_BUTTON = By.cssSelector("#MultipleUnits_Yes");
	public By MULTIPLE_UNIT_NO_RADIO_BUTTON = By.cssSelector("#MultipleUnits_No");
	public By ADDITIONAL_UNITS_FIELD_LABEL = By.cssSelector("[for='TotalUnits']");
	public By ADDITIONAL_UNITS_DROPDOWN_FIELD = By.cssSelector("#TotalUnits");
	
// ###################   Services Requested   ###################   
	public By USER_NOTE_FIELD_LABEL = By.cssSelector(".clearfix:nth-child(9) P>strong");
	
//	Military and Family Life Counselor
	public By MILITARY_COUNSELOR_FIELD_LABEL = By.cssSelector("#ServiceCategoryList h3:nth-child(2)");
	public By MILITARY_COUNSELING_PRESENTATION_CHECKBOX = By.cssSelector("#ServiceRequests_0__serviceCategoryYesNo");
	public By MILITARY_PRESENTATION_START_TIME = By.cssSelector("#ServiceRequests_0__serviceStartTime");
	public By MILITARY_PRESENTATION_END_TIME = By.cssSelector("#ServiceRequests_0__serviceEndTime");
	public By MILITARY_FACE_TO_FACE_CHECKBOX = By.cssSelector("#ServiceRequests_1__serviceCategoryYesNo");
	public By MILITARY_FACE_TO_FACE_START_TIME = By.cssSelector("#ServiceRequests_1__serviceStartTime");
	public By MILITARY_FACE_TO_FACE_END_TIME = By.cssSelector("#ServiceRequests_1__serviceEndTime");
	public By MILITARY_RESOURCE_CHECKBOX = By.cssSelector("#ServiceRequests_2__serviceCategoryYesNo");
	public By MILITARY_RESOURCE_START_TIME = By.cssSelector("#ServiceRequests_2__serviceStartTime");
	public By MILITARY_RESOURCE_END_TIME = By.cssSelector("#ServiceRequests_2__serviceEndTime");

	
//	Child and Youth Behavioral Counselor			
	public By CHILDYOUTH_COUNSELOR_FIELD_LABEL = By.cssSelector("#ServiceCategoryList h3:nth-child(6)");
	public By CHILDYOUTH_COUNSELING_PRESENTATION_CHECKBOX = By.cssSelector("#ServiceRequests_3__serviceCategoryYesNo");
	public By CHILDYOUTH_PRESENTATION_START_TIME = By.cssSelector("#ServiceRequests_3__serviceStartTime");
	public By CHILDYOUTH_PRESENTATION_END_TIME = By.cssSelector("#ServiceRequests_3__serviceEndTime");
	public By CHILDYOUTH_FACE_TO_FACE_CHECKBOX = By.cssSelector("#ServiceRequests_4__serviceCategoryYesNo");
	public By CHILDYOUTH_FACE_TO_FACE_START_TIME = By.cssSelector("#ServiceRequests_4__serviceStartTime");
	public By CHILDYOUTH_FACE_TO_FACE_END_TIME = By.cssSelector("#ServiceRequests_4__serviceEndTime");
	public By CHILDYOUTH_RESOURCE_CHECKBOX = By.cssSelector("#ServiceRequests_5__serviceCategoryYesNo");
	public By CHILDYOUTH_RESOURCE_START_TIME = By.cssSelector("#ServiceRequests_5__serviceStartTime");
	public By CHILDYOUTH_RESOURCE_END_TIME = By.cssSelector("#ServiceRequests_5__serviceEndTime");
	
//	Personal Financial Counselor
	public By PERSONAL_COUNSELOR_FIELD_LABEL = By.cssSelector("#ServiceCategoryList h3:nth-child(10)");
	public By PERSONAL_COUNSELING_PRESENTATION_CHECKBOX = By.cssSelector("#ServiceRequests_6__serviceCategoryYesNo");
	public By PERSONAL_PRESENTATION_START_TIME = By.cssSelector("#ServiceRequests_6__serviceStartTime");
	public By PERSONAL_PRESENTATION_END_TIME = By.cssSelector("#ServiceRequests_6__serviceEndTime");
	public By PERSONAL_FACE_TO_FACE_CHECKBOX = By.cssSelector("#ServiceRequests_7__serviceCategoryYesNo");
	public By PERSONAL_FACE_TO_FACE_START_TIME = By.cssSelector("#ServiceRequests_7__serviceStartTime");
	public By PERSONAL_FACE_TO_FACE_END_TIME = By.cssSelector("#ServiceRequests_7__serviceEndTime");
	public By PERSONAL_RESOURCE_CHECKBOX = By.cssSelector("#ServiceRequests_8__serviceCategoryYesNo");
	public By PERSONAL_RESOURCE_START_TIME = By.cssSelector("#ServiceRequests_8__serviceStartTime");
	public By PERSONAL_RESOURCE_END_TIME = By.cssSelector("#ServiceRequests_8__serviceEndTime");

//	Military OneSource
	public By MILITARY_ONESOURCE_FIELD_LABEL = By.cssSelector("#ServiceCategoryList h3:nth-child(14)");
	public By MILITARY_ONESOURCE_IN_PERSON_FIELD_LABEL = By.cssSelector("#ServiceCategoryList h4:nth-child(15)");

//	Military OneSource - In-Person Services
	public By ONESOURCE_PRESENTATION_CHECKBOX = By.cssSelector("#ServiceRequests_9__serviceCategoryYesNo");
	public By PRESENTATION_START_TIME = By.cssSelector("#ServiceRequests_9__serviceStartTime");
	public By PRESENTATION_END_TIME = By.cssSelector("#ServiceRequests_9__serviceEndTime");
	public By ONESOURCE_FACE_TO_FACE_CHECKBOX = By.cssSelector("#ServiceRequests_10__serviceCategoryYesNo");
	public By RESOURCE_START_TIME = By.cssSelector("#ServiceRequests_10__serviceStartTime");
	public By RESOURCE_END_TIME = By.cssSelector("#ServiceRequests_10__serviceEndTime");

//	Military OneSource - Virtual Services
	public By MILITARY_ONESOURCE_VERTUAL_FIELD_LABEL = By.cssSelector("#ServiceCategoryList h4:nth-child(18)");
	public By ONESOURCE_VERTUAL_WEBINAR_CHECKBOX = By.cssSelector("#ServiceRequests_11__serviceCategoryYesNo");
	public By TELECONFERENCE_CHECKBOX = By.cssSelector("#ServiceRequests_12__serviceCategoryYesNo");
	public By TRAINER_CHECKBOX = By.cssSelector("#ServiceRequests_13__serviceCategoryYesNo");

//##########################################  Attendance Estimates   #############################################
	public By MENDATORY_ATTENDANCE_FIELD_LABEL = By.cssSelector("[for='MemberAttendanceIsRequired_Yes'].control-label");
	public By MENDATORY_ATTENDANCE_RADIO_BUTTON_YES = By.cssSelector("#MemberAttendanceIsRequired_Yes");
	public By MENDATORY_ATTENDANCE_RADIO_BUTTON_NO = By.cssSelector("#MemberAttendanceIsRequired_No");
	
	public By SERVICE_MEMBERS_FIELD_LABEL = By.cssSelector("[for='ServiceMembers']");
	public By SERVICE_MEMBERS_FIELD_INPUT = By.cssSelector("#ServiceMembers");
	public By FAMILY_MEMBERS_FIELD_LABEL = By.cssSelector("[for='AdultFamilyMembers']");
	public By FAMILY_MEMBERS_FIELD_INPUT = By.cssSelector("#AdultFamilyMembers");
	public By CHILDREN_AGES_FIELD_LABEL = By.cssSelector("[for='ChildrenAges5to12']");
	public By CHILDREN_AGES_FIELD_INPUT = By.cssSelector("#ChildrenAges5to12");
	public By YOUTH_AGES_FIELD_LABEL = By.cssSelector("[for='ChildrenAges13to18']");
	public By YOUTH_AGES_FIELD_INPUT = By.cssSelector("#ChildrenAges13to18");
	public By ESTIMATED_TOTAL_FIELD_LABEL = By.cssSelector("[for='TotalAttendance']");
	public By ESTIMATED_TOTAL_FIELD_INPUT = By.cssSelector("#TotalAttendance");
	
//##########################################  Assignment Location  #############################################
	public By EVENT_IS_ON_INSTALLATION_FIELD_LABEL = By.cssSelector("[for='EventOnInstallation_Yes'].control-label");
	public By EVENT_IS_ON_INSTALLATION_RADIO_BUTTON_YES = By.cssSelector("#EventOnInstallation_Yes");
	public By EVENT_IS_ON_INSTALLATION_RADIO_BUTTON_NO = By.cssSelector("#EventOnInstallation_No");
	public By TYPE_OF_VENUE_FIELD_LABEL = By.cssSelector("[for='EventVenueType'].control-label");
	public By TYPE_OF_VENUE_FIELD_INPUT = By.cssSelector("#EventVenueType");
	public By STREET_ADDRESS_NOT_KNOWN_FIELD_LABEL = By.cssSelector("[for='VenueAddressUnknown'].control-label");
	public By STREET_ADDRESS_NOT_KNOWN_CHECKBOX = By.cssSelector("#VenueAddressUnknown");
	public By UNKNOWN_STREET_ADDRESS_MODAL = By.cssSelector("#unknownModal .modal-content"); 
	public By UNKNOWN_STREET_ADDRESS_MODAL_HEADER = By.cssSelector("#unknownModal .modal-header>p");
	public By UNKNOWN_STREET_ADDRESS_MODAL_X_BUTTON = By.cssSelector("#unknownModal .close");
	public By UNKNOWN_STREET_ADDRESS_MODAL_BODY = By.cssSelector("#unknownModal .modal-body>p");
	public By UNKNOWN_STREET_ADDRESS_MODAL_AGREE_BUTTON = By.cssSelector("#ModalCloseButton_unknownModal");
	public By LOCATION1_STREET_ADDRESS_FIELD_LABEL = By.cssSelector("[for='VenueAddressLine1'].control-label");
	public By LOCATION1_STREET_ADDRESS_FIELD_INPUT = By.cssSelector("#VenueAddressLine1");
	public By LOCATION2_STREET_ADDRESS_FIELD_INPUT = By.cssSelector("#VenueAddressLine2");
	public By VENUE_CITY_FIELD_LABEL = By.cssSelector("[for='VenueCityId']");
	public By VENUE_CITY_FIELD_INPUT = By.cssSelector("#VenueCityId");
	public By VENUE_STATE_INSTALLATION_FIELD_LABEL = By.cssSelector("[for='VenueStateId']");
	public By VENUE_STATE_INSTALLATION_FIELD_INPUT = By.cssSelector("#VenueStateId");
	public By VENUE_ZIP_CODE_FIELD_LABEL = By.cssSelector("[for='VenueZipCode']");
	public By VENUE_ZIP_CODE_FIELD_INPUT = By.cssSelector("#VenueZipCode");
	
//	#####################  Point of Contact Information   #####################
//	#####################      Main Point of Contact      #####################
	public By MAIN_POINT_OF_CONTACT = By.xpath("//legend[contains(text(),'Main Point of Contact')]");
	public By MPOC_NAME_FIELD_LABEL = By.cssSelector("[for='POCName']");
	public By MPOC_NAME_FIELD_INPUT = By.cssSelector("#POCName");
	public By MPOC_EMAIL_FIELD_LABEL = By.cssSelector("[for='POCEmail']");
	public By MPOC_EMAIL_FIELD_INPUT = By.cssSelector("#POCEmail");
	public By MPOC_PRIMARY_PHONE_FIELD_LABEL = By.cssSelector("[for='POCPrimaryPhone']");
	public By MPOC_PRIMARY_PHONE_FIELD_INPUT = By.cssSelector("#POCPrimaryPhone");
	public By MPOC_SECONDARY_PHONE_FIELD_LABEL = By.cssSelector("[for='POCSecondaryPhone']");
	public By MPOC_SECONDARY_PHONE_FIELD_INPUT = By.cssSelector("#POCSecondaryPhone");
	public By MPOC_PAY_GRADE_FIELD_LABEL = By.cssSelector("[for='POCRankId']");
	public By MPOC_PAY_GRADE_FIELD_INPUT = By.cssSelector("#POCRankId");

//	#####################      Alternate Point of Contact      #####################
	public By ALTERNATE_POINT_OF_CONTACT = By.cssSelector("//legend[contains(text(),'Alternate Point of Contact')]");
	public By ALTPOC_NAME_FIELD_LABEL = By.cssSelector("[for='POCName']");
	public By ALTPOC_NAME_FIELD_INPUT = By.cssSelector("#POCName");
	public By ALTPOC_EMAIL_FIELD_LABEL = By.cssSelector("[for='POCEmail']");
	public By ALTPOC_EMAIL_FIELD_INPUT = By.cssSelector("#POCEmail");
	public By ALTPOC_PRIMARY_PHONE_FIELD_LABEL = By.cssSelector("[for='POCPrimaryPhone']");
	public By ALTPOC_PRIMARY_PHONE_FIELD_INPUT = By.cssSelector("#POCPrimaryPhone");
	public By ALTPOC_SECONDARY_PHONE_FIELD_LABEL = By.cssSelector("[for='POCSecondaryPhone']");
	public By ALTPOC_SECONDARY_PHONE_FIELD_INPUT = By.cssSelector("#POCSecondaryPhone");
	public By ALTPOC_PAY_GRADE_FIELD_LABEL = By.cssSelector("[for='POCRankId']");
	public By ALTPOC_PAY_GRADE_FIELD_INPUT = By.cssSelector("#POCRankId");

//	########################  Additional Relevant Information
	public By RELEVENT_INFO_FIELD_LABEL = By.cssSelector(".col-md-5 label");
	public By RELEVENT_INFO_FIELD_INPUT = By.cssSelector("#AdditionalRelevantInformation");
	public By CHARACTERS_REMAINING_FIELD_LABEL = By.cssSelector("#textarea_feedback");
	
//	########################  Acknowledgment
	public By ACKNOWLEDGMENT_FIELD_LABEL = By.xpath("//h3[contains(text(),'Acknowledgment')]");
	public By SUPPORT_REQUEST_PROCESS_BUTTON = By.cssSelector("#ProcessButtonId");
	public By ACKNOWLEDGMENT_POPUP_MODAL = By.cssSelector("#infoModal .modal-content");
	public By ACKNOWLEDGMENT_POPUP_MODAL_HEADER = By.cssSelector("#infoModal .modal-header h3");
	public By ACKNOWLEDGMENT_POPUP_MODAL_X_BUTTON = By.cssSelector("#infoModal .close");
	public By ACKNOWLEDGMENT_POPUP_MODAL_BODY = By.cssSelector(".needToKnow");
	public By ACKNOWLEDGMENT_POPUP_MODAL_AGREE_BUTTON = By.cssSelector("#ModalAgreeButton");
	public By I_HAVE_READ_CHECKBOX = By.cssSelector("#HasReadProcessDocument");
	public By I_HAVE_READ_FIELD_LABEL = By.cssSelector("[for='HasReadProcessDocument']");
	
//	I agree to the above statement
	public By I_AGREE_STATEMENT_CHECKBOX = By.cssSelector("#AcknowledgeIsAccurate");
	public By I_AGREE_STATEMENT_FIELD_LABEL = By.cssSelector("[for='AcknowledgeIsAccurate']");
	public By SUBMIT_REQUEST_BUTTON = By.cssSelector("#requestSubmitBtn");
	
	
	
//	############################################################
//							METHODS
//	############################################################
	

















}
