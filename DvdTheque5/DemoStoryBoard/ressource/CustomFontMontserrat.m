//
//  CustomFontMontserrat.m
//  DemoStoryBoard
//
//  Created by Alexandre Guerard on 04/06/2014.
//  Copyright (c) 2014 NEOPIXL. All rights reserved.
//

#import "CustomFontMontserrat.h"

@implementation CustomFontMontserrat

- (id)initWithFrame:(CGRect)frame
{
    self = [super initWithFrame:frame];
    if (self) {
        // Initialization code
    }
    return self;
}

/*
// Only override drawRect: if you perform custom drawing.
// An empty implementation adversely affects performance during animation.
- (void)drawRect:(CGRect)rect
{
    // Drawing code
}
*/
- (void)awakeFromNib { [super awakeFromNib]; self.font = [UIFont fontWithName:@"Montserrat" size:self.font.pointSize]; }
@end
