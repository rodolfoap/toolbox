/**
* Example
* Example REST Endpoint.
*
* OpenAPI spec version: 2.3.0
* 
*
* NOTE: This class is auto generated by the swagger code generator program.
* https://github.com/swagger-api/swagger-codegen.git
* Do not edit the class manually.
*/
/*
 * ModelBase.h
 *
 * This is the base class for all model classes
 */

#ifndef ModelBase_H_
#define ModelBase_H_


#include "json.hpp"
#include <ctime>
#include <string>

namespace io {
namespace swagger {
namespace server {
namespace model {

class  ModelBase
{
public:
    ModelBase();
    virtual ~ModelBase();

    virtual void validate() = 0;

    virtual nlohmann::json toJson() const = 0;
    virtual void fromJson(nlohmann::json& json) = 0;

    static std::string toJson( const std::string& value );
    static std::string toJson( const std::time_t& value );
    static int32_t toJson( int32_t value );
    static int64_t toJson( int64_t value );
    static double toJson( double value );
    static bool toJson( bool value );
    static nlohmann::json toJson( std::shared_ptr<ModelBase> content );

};

}
}
}
}

#endif /* ModelBase_H_ */
