//
//  NPUser.h
//  DemoStoryBoard
//
//  Created by Alexandre Guerard on 28/05/2014.
//  Copyright (c) 2014 Alex. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface NPUser : NSObject
@property (nonatomic, copy) NSString *nom;
@property (nonatomic, copy) NSString *prenom;
@property (nonatomic, copy) NSString *actor;
@property (nonatomic, copy) NSString *annee;
@property (weak, nonatomic) IBOutlet UIImageView *cover;

@end
