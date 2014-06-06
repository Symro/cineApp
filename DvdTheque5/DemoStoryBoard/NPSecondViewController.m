//
//  NPSecondViewController.m
//  DemoStoryBoard
//
//  Created by Alexandre Guerard on 28/05/2014.
//  Copyright (c) 2014 Alex. All rights reserved.
//

#import "NPSecondViewController.h"

@interface NPSecondViewController ()
@property (weak, nonatomic) IBOutlet UILabel *nameLabel;
@property (weak, nonatomic) IBOutlet UILabel *prenom;
@property (weak, nonatomic) IBOutlet UILabel *actor;
@property (weak, nonatomic) IBOutlet UIImageView *cover;
@property (weak, nonatomic) IBOutlet UILabel *year;
@property (weak, nonatomic) IBOutlet UIScrollView *scrollView;

- (IBAction)tapButton:(id)sender;
- (IBAction)buttonTap:(id)sender;
- (IBAction)imageTap:(id)sender;



@end

@implementation NPSecondViewController
@synthesize buttonToggled = _buttonToggled;
//@synthesize imageToggled = _imageToggled;

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
    [[self year] setText:[[self user] annee]];
    [[self actor] setText:[[self user] actor]];
    [[self cover] setImage:[[self user] cover]];
    
    
    [[self scrollView] setContentSize:CGSizeMake(self.view.frame.size.width, 450)];
    
    
    

    
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



-(IBAction)toggleButton:(id)sender {
    if (!_buttonToggled) {
        [sender setTitle:@"BOOK IT" forState:UIControlStateNormal];
        _buttonToggled = YES;
    }
    else {
        [sender setTitle:@"NOT AVAILABLE" forState:UIControlStateNormal];
        _buttonToggled = NO;
    }
}
- (IBAction)buttonClicked:(id)sender {

}
- (IBAction)imageTap:(id)sender {
//    if (!_imageToggled) {
//        //        [[self user] nom]] = true;
//        [sender setImage:[UIImage imageNamed:@"view.jpg"]];
//        _imageToggled = YES;
//    }
//    else {
//        [sender setImage:[UIImage imageNamed:@"viewOff.jpg"]];
//        _imageToggled = NO;
//    }
}
@end
