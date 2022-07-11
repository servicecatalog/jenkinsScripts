# Azure cloud setup of OSCM Jenkins Pipelines

## Documentation
* Read the [OSCM Infrastructure in Azure ](http://estscm1.intern.est.fujitsu.com/fujitsu-bss/oscm-dev/-/raw/master/wiki/Infrastructure/OSCM_Infra_in_Azure.pdf?inline=false) wiki page.
* Watch the [intro](https://www.youtube.com/watch?v=AakecRFsFn8) video, jump to 16:35 and perform steps: 1. Create a key vault (if existing skip this part) 2. Create a Service Principal and a client secret and 3. assign an Access Policy for the sp to your key vault.

## Prerequisites
* Install [Vagrant](https://www.vagrantup.com/docs/installation)
* Valid [Azure platform](http://portal.azure.com/) subscription with service principal (registered client application with client secret) created in Azure Active Directory. Notice the three important prerequisite steps:
   *  Please copy-paste the value of the client secret to a safe place upon its creation because its value cannot be retrieved afterwards.
   *  Assign an Access Policy for your Service Principal to your key vault and add all permissions for keys and secrets.
   *  Assign the role `Contributor` for the Service Principal to the Azure Subscription of your app to enable access to all its resource groups. This can be done in the Azure Portal `Subscriptions` category in the` Access control (IAM)` tab.
   
## Getting started
As this setup is using [Microsoft Azure](https://azure.microsoft.com/) as Vagrant provider, which allows Vagrant to control and provision machines in Microsoft Azure, following steps need to be executed for make it working:
> **_NOTE:_**  Execute the commands outside of the VPN network.

```
$ vagrant box add azure https://github.com/azure/vagrant-azure/raw/v2.0/dummy.box --provider azure
$ vagrant plugin install vagrant-azure
```

Additionally, following environment variables must be set as they are used for setting up the connection to Azure platform.
Please note that `AZURE_CLIENT_SECRET` contains the value of the client secret and not the secret ID.

```
AZURE_TENANT_ID
AZURE_CLIENT_ID
AZURE_CLIENT_SECRET
AZURE_SUBSCRIPTION_ID
```

Finally, ssh private key need to be specified in Vagrantfile so that SSH connection to VM could be possible with it. It can be created by running:

```
ssh-keygen -m PEM -t rsa
```

Now to make Vargrant setup everything, simply execute

> **_NOTE:_**  Execute the command outside of the VPN network.
```
vagrant up --no-parallel
```

*Have fun!*
