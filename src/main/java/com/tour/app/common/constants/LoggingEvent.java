package com.tour.app.common.constants;

public enum LoggingEvent {
	// Framework events
	REQUEST_INPROGRESS, 
	REQUEST_COMPLETED, 
	REQUEST_FAILED,
	SESSION_CHECK_IN_PROGRESS, SESSION_CHECK_FAILED, SESSION_CHECK_SUCCESSFUL,

	// Signup events
	SIGNUP_INPROGRESS, 
	SIGNUP_SUCCESSFUL,
	SIGNUP_FAILED,

	SIGNIN_FAILED,
	SIGNIN_INPROGRESS,

	// Login events
	LOGIN_INPROGRESS,
	LOGIN_SUCCESSFUL,
	LOGIN_FAILED,

	// CommonCodeMaster
	CODE_FETCH_FAILED,

	USR_SESSION_SAVE_SUCCESSFULL, 
	USR_SESSION_SAVE_FAILED, 
	USR_SESSION_FETCH_SUCCESSFUL, 
	USR_SESSION_FETCH_FAILED,

	// Session security
	SECURITY_CHECK_IN_PROGRESS,
	SECURITY_CHECK_FAILED,

	// Facebook Login
	LONG_LIVE_TOKEN_FETCH_STATUS, 
	LONG_LIVE_TOKEN_FETCH_SUCCESSFULL,
	LONG_LIVE_TOKEN_FETCH_FAIL, 
	PROFILE_DETAILS_FETCH_STATUS,
	PROFILE_DETAILS_FETCH_SUCCESSFULL,
	PROFILE_DETAILS_FETCH_FAIL,
	EMAIL_ALREADY_EXIST, 
	USER_ID_GENERATED,

	ROUTE_INPROGRESS,
	ROUTE_SUCCESSFUL, 
	ROUTE_FAILED, 
	ROUTE_FETCHED,

	// Gameplay events
	GAMEPLAY_INPROGRESS, 
	GAMEPLAY_SUCCESSFUL, 
	GAMEPLAY_FAILED, 
	GAMEPLAY_IN_DAO, 
	GAMEPLAY_IN_SERVICE, 
	CLUEDATA_IN_SERVICE, 
	CLUEDATA_IN_DAO,

	// Corporate wise LeaderBoard
	CORPLEADERBOARD_INPROGRESS, 
	CORPLEADERBOARD_SUCCESSFUL, 
	CORPLEADERBOARD_FAILED, 
	CORPLEADERBOARD_IN_DAO, 
	CORPLEADERBOARD_IN_SERVICE,

	// TreasureHunt wise LeaderBoard
	TREASUREHUNTLEADERBOARD_INPROGRESS, 
	TREASUREHUNTLEADERBOARD_SUCCESSFUL,
	TREASUREHUNTLEADERBOARD_FAILED, 
	TREASUREHUNTLEADERBOARD_IN_DAO,
	TREASUREHUNTLEADERBOARD_IN_SERVICE,

	// ContributeClues
	CONTRIBUTECLUES_INPROGRESS,
	CONTRIBUTECLUES_SUCCESSFUL,
	CONTRIBUTECLUES_FAILED,
	CONTRIBUTECLUES_IN_DAO, 
	CONTRIBUTECLUES_IN_SERVICE,

	// CHANGE PASSWORD
	CHANGEPASSWORD_INPROGRESS,
	CHANGEPASSWORD_SUCCESSFUL, 
	CHANGEPASSWORD_FAILED,
	CHANGEPASSWORD_IN_DAO, 
	CHANGEPASSWORD_IN_SERVICE, 
	FORGOT_PASSWORD_INPROGRESS,
	FORGOT_PASSWORD_FAILED, 
	FORGOT_PASSWORD_FETCHED, 
	CORPORATE_TOKEN_FAILED,
	CORPORATE_TOKEN_FETCHED,
	CORPORATE_TOKEN_INPROGRESS,
	TREASUREHUNT_FAILED,
	TREASUREHUNT_FETCHED,
	TREASUREHUNT_INPROGRESS, 
	TREASUREHUNT_SUCCESSFUL, 
	INSIDE_APPROVED_CLUE_DAO, 
	INSIDE_CLUE_DATA_HANDLER, 
	CLUE_DATA_NOT_FOUND, 
	INSIDE_CLUE_DATA_PENDING_DAO, 
	INSIDE_CLUE_DATA_SERVICE,
	INSIDE_QRCODE_DETAILS_DAO,
	INSIDE_QRCODE_DETAILS_HANDLER, 
	QR_DATA_NOT_FOUND, 
	INSIDE_QRCODE_DETAILS_SERVICE,
	INSIDE_USER_GAME_PLAY_NODE_DATA_HANDLER, 
	GAME_PLAY_NODE_DATA_NOT_FOUND, 
	INSIDE_USER_NODE_DATA_SERVICE, 
	INSIDE_USER_NODE_GAME_PLAY_DAO,
	GET_LIST_OF_CORPORATE, 
	CORPORATE_DATA_NOT_FOUND, 
	INSIDE_CORPORATE_DETAILS_SERVICE, 
	INSIDE_CORPORATE_DAO,
	INSIDE_USER_RANK_BY_TH, 
	USER_RANK_BY_TH_DATA_NOT_FOUND, 
	INSIDE_USER_OVER_ALL_RANK_DAO, 
	INSIDE_USER_RANK_BY_TH_DAO,
	INSIDE_USER_OVERALL_RANK_HANDLER, 
	INSIDE_USER_OVER_ALL_RANK_SERVICE,
	INSIDE_USER_RANK_BY_TH_SERVICE,
	USER_OVER_ALL_RANK_DATA_NOT_FOUND, 
	INSIDE_GET_PLAYED_TREASUREHUNT_DAO,
	PLAYED_TRESUREHUNT_LIST_NOT_FOUND, 
	INSIDE_GET_PLAYED_TREASUREHUNT_HANDLER,
	INSIDE_GET_PLAYED_TREASUREHUNT_SERVICE,
	
	

    USER_ALREADY_EXIST,
   
    FACEBOOK_LOGIN_SUCCESSFUL,
    EMAIL_ALREADY_EXISTS, 
    
    
    //Near by CLUES
    NEAR_BY_CLUES_IN_DAO,
    NEAR_BY_CLUES_IN_SERVICE,
    
    //NearBy TreasureHunt
    NEAR_BY_TREASUREHUNT_IN_DAO,
    NEAR_BY_TREASUREHUNT_IN_SERVICE, 
    //DownloadImage
    IMAGE_DOWNLOAD_INPROGRESS,
    IMAGE_DOWNLOAD_FETCHED,

    IMAGE_UPLOAD_INPROGRESS,
    IMAGE_UPLOAD_COMPLETED, 
    //Notification Registration
    NOTIFICATION_REGISTRATION_INPROGRESS, 
    INSIDE_NOTIFICATION_REGISTRATION_SERVICE,
    INSIDE_NOTIFICATION_REGISTRATION_DAO, 
    CORPORATE_TOKEN_SUCCESSFULL, 
    CORPORATE_TOKEN_UNSUCCESSFULL,
    NOTIFICATION_REGISTRATION_SUCCESSFULL,
    NOTIFICATION_REGISTRATION_INSERTED_SUCCESSFULL,
    INSIDE_BROWSE_TREASUREHUNTS_HANDLER,
    INSIDE_BROWSE_TREASUREHUNTS_SERVICE,
    BROWSE_TREASUREHUNT_IN_DAO, 
    TREASUREHUNT_USERINFO_FETCHED,
    TREASUREHUNT_USERINFO_INPROGRESS, 
    TREASUREHUNT_USERINFO_INSERVICE,
    TREASUREHUNT_USERINFO_IN_DAO,
    INSIDE_BROWSE_TREASUREHUNTS_DAO, 
    TREASUREHUNTS_BASED_ON_TAGS_INPROGRESS,
    TREASUREHUNTS_BASED_ON_TAGS_FETCHED, 
    GOOGLE_LOGIN_SUCCESSFUL,
    TWITTER_LOGIN_SUCCESSFUL, 

    BROADCAST_MESSAGE_PURGE_INPROGRESS, 
 
   //Push notification 
    NOTIFICATION_INPROGRESS, 
    
    //Create BroadCastMessage
    BROADCAST_MESSAGE_INPROGRESS, 
    INSIDE_CREATE_BROADCAST_MESSAGE_SERVICE, 
    BROADCAST_MESSAGE_INSERTED_SUCCESSFULL,
    
    PUSH_NOTIFICATION_INPROGRESS,
    PUSH_NOTIFICATION_FETCHED, 
    INSIDE_PUSH_NOTIFICATION_DAO,
    INSIDE_PUSH_NOTIFICATION_SERVICE, 
    
    GCM_PUSH_INPROGRESS,
    GCM_PUSH_SUCCESSFUL,
    GCM_PUSH_FAILED, 
    INSIDE_USER_PUSHNOTIFICATION_HISTORY_DAO,
    GCM_PUSH_NOTIFICATION_FAILURE,
    GCM_PUSH_NOTIFICATION_SUCCESSFUL, 
    INSIDE_BROADCAST_MESSAGE_DETAILS_DAO, 
    INSIDE_BROADCAST_MESSAGE_MASTER_DAO, 
    INSIDE_IN_APP_NOTIFICATION_HANDLER,
    INSIDE_IN_APP_NOTIFICATION_SERVICE,
    INSIDE_USER_MESSAGE_BOX_DAO,
    CREATE_MESSAGE_INSERTED_SUCCESSFULL,
    CREATE_BROADCAST_MESSAGE_INPROGRESS,
    UPDATE_BROADCAST_MESSAGE_INPROGRESS, 
    CREATED_BROADCAST_MESSAGE_SUCCESSFULL,
    UPDATED_BROADCAST_MESSAGE_SUCCESSFULL,
    INSIDE_UPDATE_BROADCAST_MESSAGE_SERVICE,
    BROADCAST_MESSAGE_UPDATED_SUCCESSFULL, 
    PURGE_UPDATED_SUCCESSFULL,
    PURGE_INPROGRESS,
    INSIDE_PURGE_SERVICE, 
    GET_LIST_OF_LOCATIONS,
    APNS_PUSH_NOTIFICATION_FAILED,
    CLUECREATION_IN_HANDLER,
    CLUECREATION_IN_SERVICE,
	INSIDE_USER_GAME_PLAY_HISTORY_HANDLER,
	INSIDE_USER_GAME_PLAY_HISTORY_SERVICE,
	INSIDE_USER_GAME_PLAY_HISTORY_DAO, 
	CORS_FILTER_IN_PROGRESS
} 
   