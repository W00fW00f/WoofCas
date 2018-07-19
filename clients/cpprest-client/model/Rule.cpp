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



#include "Rule.h"

namespace io {
namespace swagger {
namespace client {
namespace model {

Rule::Rule()
{
    m_EntriesIsSet = false;
}

Rule::~Rule()
{
}

void Rule::validate()
{
    // TODO: implement validation
}

web::json::value Rule::toJson() const
{
    web::json::value val = web::json::value::object();

    {
        std::vector<web::json::value> jsonArray;
        for( auto& item : m_Entries )
        {
            jsonArray.push_back(ModelBase::toJson(item));
        }
        if(jsonArray.size() > 0)
        {
            val[utility::conversions::to_string_t("entries")] = web::json::value::array(jsonArray);
        }
    }

    return val;
}

void Rule::fromJson(web::json::value& val)
{
    {
        m_Entries.clear();
        std::vector<web::json::value> jsonArray;
        if(val.has_field(utility::conversions::to_string_t("entries")))
        {
        for( auto& item : val[utility::conversions::to_string_t("entries")].as_array() )
        {
            if(item.is_null())
            {
                m_Entries.push_back( std::shared_ptr<RuleEntry>(nullptr) );
            }
            else
            {
                std::shared_ptr<RuleEntry> newItem(new RuleEntry());
                newItem->fromJson(item);
                m_Entries.push_back( newItem );
            }
        }
        }
    }
}

void Rule::toMultipart(std::shared_ptr<MultipartFormData> multipart, const utility::string_t& prefix) const
{
    utility::string_t namePrefix = prefix;
    if(namePrefix.size() > 0 && namePrefix.substr(namePrefix.size() - 1) != utility::conversions::to_string_t("."))
    {
        namePrefix += utility::conversions::to_string_t(".");
    }

    {
        std::vector<web::json::value> jsonArray;
        for( auto& item : m_Entries )
        {
            jsonArray.push_back(ModelBase::toJson(item));
        }
        
        if(jsonArray.size() > 0)
        {
            multipart->add(ModelBase::toHttpContent(namePrefix + utility::conversions::to_string_t("entries"), web::json::value::array(jsonArray), utility::conversions::to_string_t("application/json")));
        }
    }
}

void Rule::fromMultiPart(std::shared_ptr<MultipartFormData> multipart, const utility::string_t& prefix)
{
    utility::string_t namePrefix = prefix;
    if(namePrefix.size() > 0 && namePrefix.substr(namePrefix.size() - 1) != utility::conversions::to_string_t("."))
    {
        namePrefix += utility::conversions::to_string_t(".");
    }

    {
        m_Entries.clear();
        if(multipart->hasContent(utility::conversions::to_string_t("entries")))
        {

        web::json::value jsonArray = web::json::value::parse(ModelBase::stringFromHttpContent(multipart->getContent(utility::conversions::to_string_t("entries"))));
        for( auto& item : jsonArray.as_array() )
        {
            if(item.is_null())
            {
                m_Entries.push_back( std::shared_ptr<RuleEntry>(nullptr) );
            }
            else
            {
                std::shared_ptr<RuleEntry> newItem(new RuleEntry());
                newItem->fromJson(item);
                m_Entries.push_back( newItem );
            }
        }
        }
    }
}

std::vector<std::shared_ptr<RuleEntry>>& Rule::getEntries()
{
    return m_Entries;
}

void Rule::setEntries(std::vector<std::shared_ptr<RuleEntry>> value)
{
    m_Entries = value;
    m_EntriesIsSet = true;
}
bool Rule::entriesIsSet() const
{
    return m_EntriesIsSet;
}

void Rule::unsetEntries()
{
    m_EntriesIsSet = false;
}

}
}
}
}

