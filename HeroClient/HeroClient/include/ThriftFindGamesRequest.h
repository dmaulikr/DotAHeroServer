/**
 * Autogenerated by Thrift
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */

#import <Foundation/Foundation.h>

#import "TProtocol.h"
#import "TApplicationException.h"
#import "TProtocolUtil.h"
#import "TProcessor.h"

#import "ThriftFlattenedEsObject.h"
#import "ThriftSearchCriteria.h"

@interface ThriftFindGamesRequest : NSObject <NSCoding> {
  ThriftSearchCriteria * __searchCriteria;

  BOOL __searchCriteria_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, strong, getter=searchCriteria, setter=setSearchCriteria:) ThriftSearchCriteria * searchCriteria;
#endif

- (id) initWithSearchCriteria: (ThriftSearchCriteria *) searchCriteria;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (ThriftSearchCriteria *) searchCriteria;
- (void) setSearchCriteria: (ThriftSearchCriteria *) searchCriteria;
- (BOOL) searchCriteriaIsSet;

@end

@interface ThriftFindGamesRequestConstants : NSObject {
}
@end
