//
//  NPTableViewController.m
//  DemoStoryBoard
//
//  Created by Fabrice Dewasmes on 5/23/14.
//  Copyright (c) 2014 NEOPIXL. All rights reserved.
//

#import "NPTableViewController.h"

#import "NPUser.h"
#import "NPSecondViewController.h"

@interface NPTableViewController ()
@property (nonatomic, retain) NSMutableArray *users;


@end

@implementation NPTableViewController

- (id)initWithStyle:(UITableViewStyle)style
{
    self = [super initWithStyle:style];
    if (self) {
        // Custom initialization
    }
    return self;
}

- (void)viewDidLoad
{
    [super viewDidLoad];
    
    // Uncomment the following line to preserve selection between presentations.
    // self.clearsSelectionOnViewWillAppear = NO;
    
    // Uncomment the following line to display an Edit button in the navigation bar for this view controller.
    // self.navigationItem.rightBarButtonItem = self.editButtonItem;
    
    [self setUsers:[[NSMutableArray alloc] initWithCapacity:3]];
    

    NPUser *a = [[NPUser alloc] init];
    [a setNom:@"HER"];
    [a setPrenom:@"Spike Jonze"];
    [a setYear:@"2013"];
    [a setActor:@"Spike Jonze, Scarlett Johansson, Amy Adams"];
    [a setCover:[UIImage imageNamed:@"her.jpg"]];
    NPUser *b = [[NPUser alloc] init];
    [b setNom:@"PULP FICTION"];
    [b setPrenom:@"Quentin Tarantino"];
    [b setYear:@"1994"];
    [b setActor:@"Uma Thurman, Samuel L.Jackson, John Travolta, Bruce Willis"];
    [b setCover:[UIImage imageNamed:@"pulpfiction.jpg"]];
    NPUser *c = [[NPUser alloc] init];
    [c setNom:@"DIKKENEK"];
    [c setPrenom:@"Olivier Van Hoostadt"];
    [c setYear:@"2006"];
    [c setActor:@"François Damiens, Mélanie Laurent, Marion Cotillard"];
    [c setCover:[UIImage imageNamed:@"dikkenek.jpg"]];
    NPUser *d = [[NPUser alloc] init];
    [d setNom:@"SNATCH"];
    [d setPrenom:@"Guy Ritchie"];
    [d setYear:@"2000"];
    [d setActor:@"Brad Pitt, Jason Statham, Vinnies Jones, Dennis Farina"];
    [d setCover:[UIImage imageNamed:@"snatch.jpeg"]];
    NPUser *e = [[NPUser alloc] init];
    [e setNom:@"THE LORD OF THE RINGS: THE RETURN OF THE KING"];
    [e setPrenom:@"Peter Jackson"];
    [e setYear:@"2003"];
    [e setActor:@"Ian McKelle, Elijah Wood, Viggo Mortensen, Sean Astin"];
    [e setCover:[UIImage imageNamed:@"LeSeigneurAnneaux.jpg"]];
    [[self users] addObject:a];
    [[self users] addObject:b];
    [[self users] addObject:c];
    [[self users] addObject:d];
    [[self users] addObject:e];
   
    self.tableView.backgroundColor = [UIColor colorWithPatternImage:[UIImage imageNamed:@"backgroundList.png"]];
    
    self.tableView.separatorStyle = UITableViewCellSeparatorStyleNone;
    

}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

#pragma mark - Table view data source

- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView
{

    // Return the number of sections.
    return 1;
}

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section
{
    return [[self users] count];
}


- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath
{
    UITableViewCell *cell = [tableView dequeueReusableCellWithIdentifier:@"cell" forIndexPath:indexPath];
    
    // Configure the cell...
    
    UILabel *label = (UILabel *)[cell viewWithTag:100];
    [label setText:[[[self users] objectAtIndex:indexPath.row] nom]];
    
    UILabel *label2 = (UILabel *)[cell viewWithTag:103];
    [label2 setText:[[[self users] objectAtIndex:indexPath.row] prenom]];
    

    

    
    
    
    UIImageView *imageView = (UIImageView *)[cell viewWithTag:101];
    [imageView setImage:[[[self users] objectAtIndex:indexPath.row] cover]];

    return cell;
}


/*
// Override to support conditional editing of the table view.
- (BOOL)tableView:(UITableView *)tableView canEditRowAtIndexPath:(NSIndexPath *)indexPath
{
    // Return NO if you do not want the specified item to be editable.
    return YES;
}
*/

/*
// Override to support editing the table view.
- (void)tableView:(UITableView *)tableView commitEditingStyle:(UITableViewCellEditingStyle)editingStyle forRowAtIndexPath:(NSIndexPath *)indexPath
{
    if (editingStyle == UITableViewCellEditingStyleDelete) {
        // Delete the row from the data source
        [tableView deleteRowsAtIndexPaths:@[indexPath] withRowAnimation:UITableViewRowAnimationFade];
    } else if (editingStyle == UITableViewCellEditingStyleInsert) {
        // Create a new instance of the appropriate class, insert it into the array, and add a new row to the table view
    }   
}
*/

/*
// Override to support rearranging the table view.
- (void)tableView:(UITableView *)tableView moveRowAtIndexPath:(NSIndexPath *)fromIndexPath toIndexPath:(NSIndexPath *)toIndexPath
{
}
*/

/*
// Override to support conditional rearranging of the table view.
- (BOOL)tableView:(UITableView *)tableView canMoveRowAtIndexPath:(NSIndexPath *)indexPath
{
    // Return NO if you do not want the item to be re-orderable.
    return YES;
}
*/


#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender
{
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
    NPSecondViewController * vc = (NPSecondViewController *)[segue destinationViewController];
    
    NSIndexPath *indexPath = [self.tableView indexPathForSelectedRow];
    [vc setUser:[[self users] objectAtIndex:indexPath.row]];
    
}


@end
