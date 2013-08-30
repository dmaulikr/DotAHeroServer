//
//  Autogenerated by CocoaTouchApiGenerator
//
//  DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
//



#import "EsDHSharedModulusRequest.h"
#import "EsThriftUtil.h"

@implementation EsDHSharedModulusRequest

@synthesize number = number_;

- (id) initWithThriftObject: (id) thriftObject {
	if ((self = [super init])) {
		self.messageType = EsMessageType_DHSharedModulusRequest;
		if (thriftObject != nil) {
			[self fromThrift: thriftObject];
		}
	}
	return self;
}

- (id) init {
	return [self initWithThriftObject: nil];
}

- (void) fromThrift: (id) thriftObject {
	ThriftDHSharedModulusRequest* t = (ThriftDHSharedModulusRequest*) thriftObject;
	if ([t numberIsSet] && t.number != nil) {
		self.number = t.number;
	}
}

- (ThriftDHSharedModulusRequest*) toThrift {
	ThriftDHSharedModulusRequest* _t = [[ThriftDHSharedModulusRequest alloc] init];;
	if (number_set_ && number_ != nil) {
		NSString* _number;
		_number = self.number;
		_t.number = _number;
	}
	return _t;
}

- (id) newThrift {
	return [[ThriftDHSharedModulusRequest alloc] init];
}

- (void) setNumber: (NSString*) number {
	number_ = number;
	number_set_ = true;
}


@end