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

#import "ThriftFlattenedEsObjectRO.h"
#import "ThriftErrorType.h"

@interface ThriftCreateOrJoinGameResponse : NSObject <NSCoding> {
  BOOL __successful;
  int __error;
  int32_t __zoneId;
  int32_t __roomId;
  int32_t __gameId;
  ThriftFlattenedEsObjectRO * __gameDetails;

  BOOL __successful_isset;
  BOOL __error_isset;
  BOOL __zoneId_isset;
  BOOL __roomId_isset;
  BOOL __gameId_isset;
  BOOL __gameDetails_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, getter=successful, setter=setSuccessful:) BOOL successful;
@property (nonatomic, getter=error, setter=setError:) int error;
@property (nonatomic, getter=zoneId, setter=setZoneId:) int32_t zoneId;
@property (nonatomic, getter=roomId, setter=setRoomId:) int32_t roomId;
@property (nonatomic, getter=gameId, setter=setGameId:) int32_t gameId;
@property (nonatomic, strong, getter=gameDetails, setter=setGameDetails:) ThriftFlattenedEsObjectRO * gameDetails;
#endif

- (id) initWithSuccessful: (BOOL) successful error: (int) error zoneId: (int32_t) zoneId roomId: (int32_t) roomId gameId: (int32_t) gameId gameDetails: (ThriftFlattenedEsObjectRO *) gameDetails;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (BOOL) successful;
- (void) setSuccessful: (BOOL) successful;
- (BOOL) successfulIsSet;

- (int) error;
- (void) setError: (int) error;
- (BOOL) errorIsSet;

- (int32_t) zoneId;
- (void) setZoneId: (int32_t) zoneId;
- (BOOL) zoneIdIsSet;

- (int32_t) roomId;
- (void) setRoomId: (int32_t) roomId;
- (BOOL) roomIdIsSet;

- (int32_t) gameId;
- (void) setGameId: (int32_t) gameId;
- (BOOL) gameIdIsSet;

- (ThriftFlattenedEsObjectRO *) gameDetails;
- (void) setGameDetails: (ThriftFlattenedEsObjectRO *) gameDetails;
- (BOOL) gameDetailsIsSet;

@end

@interface ThriftCreateOrJoinGameResponseConstants : NSObject {
}
@end
