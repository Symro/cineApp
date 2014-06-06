//
//  NPSecondViewController.h
//  DemoStoryBoard
//
//  Created by Alexandre Guerard on 28/05/2014.
//  Copyright (c) 2014 Alex. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "NPUser.h"
@interface NPSecondViewController : UIViewController

@property (weak, nonatomic) IBOutlet UIButton *ButtonEtat;
@property (nonatomic, retain) NPUser *user;
@property (nonatomic, assign) bool *buttonToggled;
//@property (nonatomic, assign) bool *imageToggled;


@end
