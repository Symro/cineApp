//
//  NPSecondViewController.m
//  DemoStoryBoard
//
//  Created by Fabrice Dewasmes on 5/23/14.
//  Copyright (c) 2014 NEOPIXL. All rights reserved.
//

#import "NPSecondViewController.h"

@interface NPSecondViewController ()
@property (weak, nonatomic) IBOutlet UILabel *nameLabel;
@property (weak, nonatomic) IBOutlet UILabel *prenom;
@property (weak, nonatomic) IBOutlet UILabel *actor;
@property (weak, nonatomic) IBOutlet UIImageView *cover;
@property (weak, nonatomic) IBOutlet UILabel *year;

@end

@implementation NPSecondViewController

- (id)initWithNibName:(NSString *)nibNameOrNil bundle:(NSBundle *)nibBundleOrNil
{
    self = [super initWithNibName:nibNameOrNil bundle:nibBundleOrNil];
    if (self) {
        // Custom initialization
    }
    return self;
}

- (void)viewDidLoad
{
    [super viewDidLoad];
    // Do any additional setup after loading the view.
    
    [[self nameLabel] setText:[[self user] nom]];
    [[self prenom] setText:[[self user] prenom]];
    [[self year] setText:[[self user] year]];
    [[self actor] setText:[[self user] actor]];
    [[self cover] setImage:[[self user] cover]];
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

/*
#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender
{
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
}
*/

@end
