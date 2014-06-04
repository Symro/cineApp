//
//  NPUser.h
//  DemoStoryBoard
//
//  Created by Fabrice Dewasmes on 5/23/14.
//  Copyright (c) 2014 NEOPIXL. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface NPUser : NSObject
@property (nonatomic, copy) NSString *nom;
@property (nonatomic, copy) NSString *prenom;
@property (nonatomic, copy) NSString *actor;
@property (nonatomic, copy) NSString *year;
@property (weak, nonatomic) IBOutlet UIImageView *cover;

@end
