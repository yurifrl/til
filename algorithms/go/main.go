package main

import (
	"github.com/k0kubun/pp"
)

func main() {
	css := [][]int32{[]int32{1, 60}, []int32{2, 20}, []int32{3, 95}, []int32{4, 75}}
	customers := [][]int32{[]int32{1, 90}, []int32{2, 20}, []int32{3, 70}, []int32{4, 40}, []int32{5, 60}, []int32{6, 10}}
	vacantCss := []int32{2, 4}

	res := csRush(int32(len(css)), int32(len(customers)), css, customers, vacantCss)

	pp.Println(res)
}

// Boundaries
type Manager struct {
	Id         int32
	Capability int32
	Customers  []Customer
}
type Customer struct {
	Id   int32
	Size int32
}

func (manager *Manager) AddCustomer(customer Customer) {
	manager.Customers = append(manager.Customers, customer)
}

// csRush Returns the id of the manager that will handler MORE customers
func csRush(managersCount int32, customersCount int32, managers [][]int32, customers [][]int32, managersVacant []int32) int32 {
	typedManagers := make(map[int32]Manager)
	typedCustomers := make(map[int32]Customer)

	for _, x := range managers {
		typedManagers[x[0]] = Manager{Id: x[0], Capability: x[1]}
	}

	for _, x := range customers {
		typedCustomers[x[0]] = Customer{Id: x[0], Size: x[1]}
	}

	// Ignore vacant managers
	for _, i := range managersVacant {
		delete(typedManagers, i)
	}

	return csRush2(typedManagers, typedCustomers)
}

func csRush2(managers map[int32]Manager, customers map[int32]Customer) int32 {
	var capabilities []int32
	// List of available capabilities
	for _, c := range managers {
		capabilities = append(capabilities, c.Capability)
	}

	// Sort Customers into Managers
	for _, c := range customers {
		for _, m := range managers {
			if hasMoreSuitableManager(c.Size, m.Capability, capabilities) {
				continue
			}
			m.AddCustomer(c)
			managers[m.Id] = m
		}
	}

	pp.Println(managers)

	return electMangerBasedOnLoad(managers).Id
}

// findMoreSuitableManager return true if has a manager with less capacity for to handler
func hasMoreSuitableManager(size int32, current int32, available []int32) bool {
	//pp.Println(current)
	hasAmatch := false
	for _, a := range available {
		if current == a {
			continue
		}
		if current < size {
			// Already not the best
			pp.Println(size)
			pp.Println(a)
		}

		if size > current && size < a {
			return true
		}
		if size <= a {
			return true
		}
	}
	return false
}

func electMangerBasedOnLoad(managers map[int32]Manager) Manager {
	var largestCustomerCount int
	var elected Manager
	for _, m := range managers {
		customersCount := len(m.Customers)
		if customersCount > largestCustomerCount {
			largestCustomerCount = customersCount
			elected = m
		}
	}

	return elected
}

// Boundaries
