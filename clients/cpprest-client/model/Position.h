/**
 * CrashAvoidanceSystem
 * This is a CAS server.  You can find out more about     Swagger at [http://swagger.io](http://swagger.io) or on [irc.freenode.net, #swagger](http://swagger.io/irc/).
 *
 * OpenAPI spec version: 1.0.0
 * Contact: apiteam@swagger.io
 *
 * NOTE: This class is auto generated by the swagger code generator 2.3.1.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

/*
 * Position.h
 *
 * 
 */

#ifndef IO_SWAGGER_CLIENT_MODEL_Position_H_
#define IO_SWAGGER_CLIENT_MODEL_Position_H_


#include "../ModelBase.h"


namespace io {
namespace swagger {
namespace client {
namespace model {

/// <summary>
/// 
/// </summary>
class  Position
    : public ModelBase
{
public:
    Position();
    virtual ~Position();

    /////////////////////////////////////////////
    /// ModelBase overrides

    void validate() override;

    web::json::value toJson() const override;
    void fromJson(web::json::value& json) override;

    void toMultipart(std::shared_ptr<MultipartFormData> multipart, const utility::string_t& namePrefix) const override;
    void fromMultiPart(std::shared_ptr<MultipartFormData> multipart, const utility::string_t& namePrefix) override;

    /////////////////////////////////////////////
    /// Position members

    /// <summary>
    /// 
    /// </summary>
    int64_t getLatitude() const;
    bool latitudeIsSet() const;
    void unsetLatitude();
    void setLatitude(int64_t value);
    /// <summary>
    /// 
    /// </summary>
    int64_t getLongitude() const;
    bool longitudeIsSet() const;
    void unsetLongitude();
    void setLongitude(int64_t value);

protected:
    int64_t m_Latitude;
    bool m_LatitudeIsSet;
    int64_t m_Longitude;
    bool m_LongitudeIsSet;
};

}
}
}
}

#endif /* IO_SWAGGER_CLIENT_MODEL_Position_H_ */