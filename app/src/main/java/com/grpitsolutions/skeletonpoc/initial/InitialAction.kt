package com.grpitsolutions.skeletonpoc.initial

sealed interface InitialAction {
    object AddPerson: InitialAction
    object AddCard: InitialAction
    object ListAllCards: InitialAction
    object ListAllPersons: InitialAction

}