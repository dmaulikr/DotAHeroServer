//
//  Autogenerated by CocoaTouchApiGenerator
//
//  DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
//



#import "EsMessage.h"
#import "EsMessageType.h"
#import "EsRequest.h"
#import "EsResponse.h"
#import "EsEvent.h"
#import "EsEntity.h"
#import "EsObject.h"
#import "ThriftCrossDomainPolicyResponse.h"

@interface EsCrossDomainPolicyResponse : EsResponse {
@private
	BOOL customFileEnabled_set_;
	BOOL customFileEnabled_;
	BOOL customFileContents_set_;
	NSString* customFileContents_;
	BOOL port_set_;
	int32_t port_;
}

@property(nonatomic) BOOL customFileEnabled;
@property(strong,nonatomic) NSString* customFileContents;
@property(nonatomic) int32_t port;

- (id) init;
- (id) initWithThriftObject: (id) thriftObject;
- (void) fromThrift: (id) thriftObject;
- (ThriftCrossDomainPolicyResponse*) toThrift;
- (id) newThrift;
@end
