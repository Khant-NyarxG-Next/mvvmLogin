package com.khantnyar.mvvm_login.data.api.response

import com.google.gson.annotations.SerializedName


data class LoginResponse(
    @SerializedName("id") var id: Any?,
    @SerializedName("jsonrpc") var jsonrpc: String?,
    @SerializedName("result") var result: Result?
) {
    data class Result(
        @SerializedName("active_ids_limit") var activeIdsLimit: Int?,
        @SerializedName("bundle_params") var bundleParams: BundleParams?,
        @SerializedName("cache_hashes") var cacheHashes: CacheHashes?,
        @SerializedName("company_id") var companyId: Int?,
        @SerializedName("currencies") var currencies: Map<Int, MapValue?>?,
        @SerializedName("db") var db: String?,
        @SerializedName("dbuuid") var dbuuid: String?,
        @SerializedName("display_switch_company_menu") var displaySwitchCompanyMenu: Boolean?,
        @SerializedName("home_action_id") var homeActionId: Boolean?,
        @SerializedName("iap_company_enrich") var iapCompanyEnrich: Boolean?,
        @SerializedName("is_admin") var isAdmin: Boolean?,
        @SerializedName("is_system") var isSystem: Boolean?,
        @SerializedName("max_file_upload_size") var maxFileUploadSize: Int?,
        @SerializedName("max_time_between_keys_in_ms") var maxTimeBetweenKeysInMs: Int?,
        @SerializedName("name") var name: String?,
        @SerializedName("notification_type") var notificationType: String?,
        @SerializedName("odoobot_initialized") var odoobotInitialized: Boolean?,
        @SerializedName("partner_display_name") var partnerDisplayName: String?,
        @SerializedName("partner_id") var partnerId: Int?,
        @SerializedName("profile_collectors") var profileCollectors: Any?,
        @SerializedName("profile_params") var profileParams: Any?,
        @SerializedName("profile_session") var profileSession: Any?,
        @SerializedName("server_version") var serverVersion: String?,
        @SerializedName("server_version_info") var serverVersionInfo: List<Any?>?,
        @SerializedName("show_effect") var showEffect: Boolean?,
        @SerializedName("support_url") var supportUrl: String?,
        @SerializedName("tour_disable") var tourDisable: Boolean?,
        @SerializedName("uid") var uid: Int?,
        @SerializedName("user_companies") var userCompanies: UserCompanies?,
        @SerializedName("user_context") var userContext: UserContext?,
        @SerializedName("user_id") var userId: List<Int?>?,
        @SerializedName("username") var username: String?,
        @SerializedName("web.base.url") var webBaseUrl: String?,
        @SerializedName("web_tours") var webTours: List<Any?>?
    ) {
        data class BundleParams(
            @SerializedName("lang") var lang: String?
        )

        data class CacheHashes(
            @SerializedName("load_menus") var loadMenus: String?,
            @SerializedName("translations") var translations: String?
        )

        data class MapValue(
            @SerializedName("digits") var digits: List<Int?>?,
            @SerializedName("position") var position: String?,
            @SerializedName("symbol") var symbol: String?
        )

        data class UserCompanies(
            @SerializedName("allowed_companies") var allowedCompanies: Map<Int, MapValue?>?,
            @SerializedName("current_company") var currentCompany: Int?
        ) {
            data class MapValue(
                @SerializedName("id") var id: Int?,
                @SerializedName("name") var name: String?,
                @SerializedName("sequence") var sequence: Int?
            )
        }

        data class UserContext(
            @SerializedName("lang") var lang: String?,
            @SerializedName("tz") var tz: String?,
            @SerializedName("uid") var uid: Int?
        )
    }
}
