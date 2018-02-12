/**
 *  ****************  Message Central..  ****************
 *
 *  Design Usage:
 *  This is the 'Parent' app for message automation..
 *
 *
 *  Copyright 2017 Andrew Parker.
 *  
 *  This SmartApp is free!
 *  Donations to support development efforts are accepted via: 
 *
 *  Paypal at: https://www.paypal.me/smartcobra
 *  
 *
 *  I'm very happy for you to use this app without a donation, but if you find it useful then it would be nice to get a 'shout out' on the forum! -  @Cobra
 *  Have an idea to make this app better?  - Please let me know :)
 *
 *  Website: http://securendpoint.com/smartthings
 *
 *-------------------------------------------------------------------------------------------------------------------
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *-------------------------------------------------------------------------------------------------------------------
 *
 *  If modifying this project, please keep the above header intact and add your comments/credits below - Thank you! -  @Cobra
 *
 *-------------------------------------------------------------------------------------------------------------------
 *
 *  Last Update: 03/09/2017
 *
 *  Changes:
 *
 * 
 *
 *  V1.0.2 - Added icons
 *  V1.0.1 - Header & Debug
 *  V1.0.0 - POC
 *
 */

 
 definition(
    name: "Message Central",
    namespace: "Cobra",
    author: "Andrew Parker",
    description: "Parent App for Message Automation.",
   category: "Fun & Social",
    iconUrl: "https://raw.githubusercontent.com/cobravmax/SmartThings/master/icons/voice.png",
    iconX2Url: "https://raw.githubusercontent.com/cobravmax/SmartThings/master/icons/voice.png",
    iconX3Url: "https://raw.githubusercontent.com/cobravmax/SmartThings/master/icons/voice.png")

preferences {
    
    page(name: "mainPage", title: "Automations", install: true, uninstall: true,submitOnChange: true) {
    
    section() {
    
        paragraph image: "https://raw.githubusercontent.com/cobravmax/SmartThings/master/icons/voice.png",
                  title: "Multiple Message Control",
                  required: false,
                  "This parent app is a container for all message child apps"
    }
    section() {
           paragraph image: "https://raw.githubusercontent.com/cobravmax/SmartThings/master/icons/cobra3.png",
                         "Parent Version: 1.0.2 -  Copyright © 2017 Cobra"
    }
    section {
            app(name: "switchMessageAutomation", appName: "Message_Central_Child", namespace: "Cobra", title: "Create New Triggered Message", multiple: true)
           
            }
            
           
            
    }
}

def installed() {
    log.debug "Installed with settings: ${settings}"
    initialize()
}

def updated() {
    log.debug "Updated with settings: ${settings}"
    unsubscribe()
    initialize()
}

def initialize() {
    log.debug "there are ${childApps.size()} child smartapps"
    childApps.each {child ->
        log.debug "child app: ${child.label}"
    }
    
   
    
}